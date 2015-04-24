package jbehave.demo.steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SimpleSteps {

    @Given("a system state")
    public void givenStep(){

        System.out.print("Step1\n");
    }

    @When("I do something")
         public void whenStep(){
        System.out.print("Step2\n");
    }

    @Then("system is in a different state")
    public void thenStep(){
        System.out.print("Step3\n");
    }
}
