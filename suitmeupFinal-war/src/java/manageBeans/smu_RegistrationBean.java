/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserCredentials;
import db.SmuUserDetails;
import db.SmuUserPersonalDetails;
import db.SmuUserProfessionalDetails;
import ejbs.UserCredentialsLocal;
import ejbs.UserDetailsLocal;
import ejbs.UserPersonalDetailsLocal;
import ejbs.UserProfessionalDetailsLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaClasses.smu_Registration;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author MANALI
 */
@ManagedBean(name = "registerBean")
@ViewScoped
public class smu_RegistrationBean implements Serializable {

    @EJB
    private UserProfessionalDetailsLocal userProfessionalDetails;
    @EJB
    private UserPersonalDetailsLocal userPersonalDetails;
    @EJB
    private UserCredentialsLocal userCredentials;
    @EJB
    private UserDetailsLocal userDetails;

    private smu_Registration user = new smu_Registration();
    private SmuUserPersonalDetails personal = new SmuUserPersonalDetails();
    private SmuUserProfessionalDetails professional = new SmuUserProfessionalDetails();
    private SmuUserDetails details = new SmuUserDetails();
    private SmuUserCredentials credentials = new SmuUserCredentials();

    private Map<String, Map<String, String>> Statedata = new HashMap<String, Map<String, String>>();
    private Map<String, Map<String, String>> Citydata = new HashMap<String, Map<String, String>>();
    private Map<String, String> countries = new HashMap<String, String>();
    private Map<String, String> states = new HashMap<String, String>();
    private Map<String, String> cities = new HashMap<String, String>();

    @PostConstruct
    public void init() {
        countries = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");

        Map<String, String> Statemap;
        Map<String, String> Cityemap;

        Statemap = new HashMap<String, String>();
        Statemap.put("State1", "state1");
        Statemap.put("State2", "state2");
        Statedata.put("USA", Statemap);
        Cityemap = new HashMap<String, String>();
        Cityemap.put("New York", "New York");
        Cityemap.put("San Francisco", "San Francisco");
        Cityemap.put("Denver", "Denver");
        Citydata.put("state1", Cityemap);
        Cityemap = new HashMap<String, String>();
        Cityemap.put("Berlin", "Berlin");
        Cityemap.put("Munich", "Munich");
        Cityemap.put("Frankfurt", "Frankfurt");
        Citydata.put("state2", Cityemap);

    }

    public SmuUserCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(SmuUserCredentials credentials) {
        this.credentials = credentials;
    }

    public SmuUserPersonalDetails getPersonal() {
        return personal;
    }

    public void setPersonal(SmuUserPersonalDetails personal) {
        this.personal = personal;
    }

    public SmuUserDetails getDetails() {
        return details;
    }

    public void setDetails(SmuUserDetails details) {
        this.details = details;
    }

    public SmuUserProfessionalDetails getProfessional() {
        return professional;
    }

    public void setProfessional(SmuUserProfessionalDetails professional) {
        this.professional = professional;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public Map<String, Map<String, String>> getStatedata() {
        return Statedata;
    }

    public void setStatedata(Map<String, Map<String, String>> Statedata) {
        this.Statedata = Statedata;
    }

    public Map<String, Map<String, String>> getCitydata() {
        return Citydata;
    }

    public void setCitydata(Map<String, Map<String, String>> Citydata) {
        this.Citydata = Citydata;
    }

    public Map<String, String> getStates() {
        return states;
    }

    public void setStates(Map<String, String> states) {
        this.states = states;
    }

    public void onCountryChange() {
        String country = details.getUdUserCountry();
        System.out.println("Selected " + country);
        if (country != null && !country.equals("")) {
            states = Statedata.get(country);
        } else {
            states = new HashMap<String, String>();
        }
    }

    public void onStateChange() {
        String state = details.getUdUserState();
        System.out.println("Selected " + state);
        if (state != null && !state.equals("")) {
            cities = Citydata.get(state);
        } else {
            cities = new HashMap<String, String>();
        }
    }

    public smu_Registration getUser() {
        return user;
    }

    public void setUser(smu_Registration user) {
        this.user = user;
    }

    public void save() {
        credentials.setUcUserUserName(user.getUsername()); // setup credetial object 
        credentials.setUcUserEmail(user.getEmail());
        credentials.setUcUserPassword(UserSession.encryptPassword(user.getPassword()));
        
        userCredentials.createCredentials(credentials); //call ejb method and create user
        System.out.println(credentials.getUcUserId());
        details.setUcUserId(credentials.getUcUserId());
        userDetails.createUserDetails(details);    /// update details of that user

        personal.setUcUserId(credentials.getUcUserId());
        personal.setUpdPersonalPicture("default.png");
        userPersonalDetails.createPersonalDetails(personal); // create personal detailof that user

        professional.setUcUserId(credentials.getUcUserId());
        professional.setUpdProfessionalPicture("default.png");
        userProfessionalDetails.createProfessionalDetails(professional);  // create professional detail of that user
        FacesMessage msg = new FacesMessage("Successful Welcome :");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath()+"/home.xhtml?uname="+credentials.getUcUserUserName()); // redirect to profile
        } catch (IOException ex) {
            Logger.getLogger(smu_RegistrationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public smu_RegistrationBean() {
    }

}
