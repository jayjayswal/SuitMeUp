/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserPersonalDetails;
import ejbs.UserPersonalDetailsLocal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jay
 */
@ManagedBean
@RequestScoped
public class UserPersonalDetails {
    @EJB
    private UserPersonalDetailsLocal userPersonalDetails1;

    UserSession Usersession = null;
    private UploadedFile file=null;
    public SmuUserPersonalDetails selectedUserPersonalDetails;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
    public SmuUserPersonalDetails getSelectedUserPersonalDetails() {
        return selectedUserPersonalDetails;
    }

    public void setSelectedUserPersonalDetails(SmuUserPersonalDetails selectedUserPersonalDetails) {
        this.selectedUserPersonalDetails = selectedUserPersonalDetails;
    }
    
    public UserPersonalDetails() {
    }
    
    @PostConstruct
    public void init(){
        Usersession = (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
        if(Usersession==null){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()+"/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if(Usersession.session==null){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()+"/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        selectedUserPersonalDetails = userPersonalDetails1.getUserPersonalDetails(Usersession.session.getUcUserId());    
    }
    
    private String getExtention(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
    public void updateDetails(){
        
        OutputStream out = null;
        try {
            InputStream in = null;
            if(!(file.getFileName().isEmpty())){
                System.out.println("file name"+file.getFileName());
                FacesContext fc = FacesContext.getCurrentInstance();
                ExternalContext ec = fc.getExternalContext();
                String path=ec.getRealPath("/resources/profileImages")+"/" + Usersession.session.getUcUserId() + "0." + this.getExtention(file.getFileName());
                System.out.println(path); 
                int read = 0;
                System.out.println(path);
                File yourFile = new File(path);
                if(!yourFile.exists()) {
                    yourFile.createNewFile();
                } 

                out = new FileOutputStream(new File(path),false);
                byte[] bytes = new byte[1024];
                in = file.getInputstream();
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
                out.close();
                selectedUserPersonalDetails.setUpdPersonalPicture(Usersession.session.getUcUserId() + "0." + this.getExtention(file.getFileName()));
            }
            userPersonalDetails1.updatePersonalDetails(selectedUserPersonalDetails);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserProfessionDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserProfessionDetails.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
