package StepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
 @Before("@delete")
  public void beforedelete() throws Throwable {
	 
	 GoogleAPIStepDefination m= new GoogleAPIStepDefination();
	 if(m.id==null) {
	 m.add_the_payload("Manish1", "Hisar", "Gali");
	 m.user_submit_the_api_with_method("addplace", "POST");}
	 
 }
 
}
