package cscie88a.week3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionServiceTest {

    private AdoptionService service;

    @BeforeEach
    void setUp() throws Exception {
        service = new AdoptionService();
    }

    @Test
    public void testTryToAdoptNoArg(){
        // 1. verify that if adoptionFeePaid = true - the result is also 'true'
        assertTrue(service.tryToAdoptNoArg(() -> true, true));

        // 2. verify that if adoptionFeePaid = false - the result is also 'false'
        assertFalse(service.tryToAdoptNoArg(() -> true, false));
    }

    @Test
    public void testTryToAdoptOneArg(){
        // 1. verify that if healthCheckDone = true and adoptionFeePaid = true - the result is also 'true'
        assertTrue(service.tryToAdoptOneArg((healthCheckDone) -> healthCheckDone, true, true));

        // 2. verify that if healthCheckDone = false and adoptionFeePaid = true - the result is 'false'
        assertFalse(service.tryToAdoptOneArg((healthCheckDone) -> healthCheckDone, false, true));

        // 3. verify that if healthCheckDone = true and adoptionFeePaid = false - the result is 'false'
        assertFalse(service.tryToAdoptOneArg((healthCheckDone) -> healthCheckDone, true, false));

        // 4. verify that if healthCheckDone = false and adoptionFeePaid = false - the result is 'false'
        assertFalse(service.tryToAdoptOneArg((healthCheckDone) -> healthCheckDone, false, false));
    }

    @Test
    public void testTryToAdoptNoArg_namedLambda(){
        IAdoptable readyForAdoption = () -> true;

        // 1. verify that if adoptionFeePaid = true - the result is also 'true'
        assertTrue(service.tryToAdoptNoArg(readyForAdoption, true));

        // 2. verify that if adoptionFeePaid = false - the result is also 'false'
        assertFalse(service.tryToAdoptNoArg(readyForAdoption, false));
    }

    @Test
    public void testTryToAdoptOneArg_namedLambda(){
        IAdoptable2 readyForAdoption = (healthCheckDone) -> healthCheckDone;

        // 1. verify that if healthCheckDone = true and adoptionFeePaid = true - the result is also 'true'
        assertTrue(service.tryToAdoptOneArg(readyForAdoption, true, true));

        // 2. verify that if healthCheckDone = false and adoptionFeePaid = true - the result is 'false'
        assertFalse(service.tryToAdoptOneArg(readyForAdoption, false, true));

        // 3. verify that if healthCheckDone = true and adoptionFeePaid = false - the result is 'false'
        assertFalse(service.tryToAdoptOneArg(readyForAdoption, true, false));

        // 4. verify that if healthCheckDone = false and adoptionFeePaid = false - the result is 'false'
        assertFalse(service.tryToAdoptOneArg(readyForAdoption, false, false));
    }

}