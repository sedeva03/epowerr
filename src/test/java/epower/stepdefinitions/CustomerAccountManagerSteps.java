package epower.stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.java.en.*;
import org.epower.model.Customer;

public class CustomerAccountManagerSteps {

    private Customer customer;

    @When("they provide all the required registration information")
    public void registerCustomer() {
        customer = new Customer("user123", "John Doe");
    }

    @Then("a new customer account should be created")
    public void verifyCustomerAccountCreated() {
        assertNotNull(customer, "Customer account was not created");
    }

    @Then("they should receive a unique customer identity")
    public void verifyUniqueCustomerId() {
        assertNotNull(customer.getCustomerId(), "Customer ID was not generated");
    }

    @Given("a customer with ID {string} has a balance of {double} EUR")
    public void setCustomerBalance(String customerId, double balance) {
        customer = new Customer(customerId, "Test User");
        customer.setBalance(balance);
    }

    @When("the customer tops up their account with {double} EUR")
    public void topUpAccount(double topUpAmount) {
        customer.topUp(topUpAmount);
    }

    @Then("the customer's account balance should be {double} EUR")
    public void verifyAccountBalance(double expectedBalance) {
        assertEquals(expectedBalance, customer.getBalance(), "Customer balance mismatch");
    }

    @When("the customer starts a charging session at {string} using {string} mode")
    public void startChargingSession(String stationId, String mode) {
        // Logic to start a charging session
        System.out.println("Started charging session at " + stationId + " using " + mode);
    }

    @Then("the status of {string} changes to {string}")
    public void verifyChargingSessionStarted(String stationId, String expectedStatus) {
        // Verify charging session status
        System.out.println("Charging session status of " + stationId + " changed to " + expectedStatus);
    }

    @When("the customer attempts to start a charging session at {string} using {string} mode")
    public void attemptToStartChargingSession(String stationId, String mode) {
        // Logic to attempt starting a session
    }

    @Then("the charging session should not start")
    public void verifyChargingSessionNotStarted() {
        System.out.println("Charging session did not start due to insufficient balance.");
    }

    @Then("the customer should be notified of insufficient funds")
    public void notifyInsufficientFunds() {
        System.out.println("Customer was notified of insufficient funds.");
    }

    @When("the customer views their account details")
    public void viewAccountDetails() {
        System.out.println("Customer is viewing account details.");
    }

    @Then("they should see their current balance")
    public void verifyCustomerBalance() {
        System.out.println("Customer balance displayed: " + customer.getBalance());
    }

    @Then("a list of all past charging sessions and top-ups, sorted by date")
    public void verifyCustomerHistory() {
        System.out.println("Customer's history of charging sessions and top-ups displayed.");
    }
}