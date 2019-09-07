package com.example.hldbs;

import com.example.hldbs.controller.AccountController;
import com.example.hldbs.controller.AuthController;
import com.example.hldbs.webentity.GenericResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HldbsApplicationTests {

    @Test
    public void testAuthentication() {
        AuthController controller = new AuthController();
        GenericResponse result = controller.authenticate("1234");
        String message = result.getMessage();
        boolean success = result.isSuccess();
        assert success;
        assert message.equalsIgnoreCase("success");

        result = controller.authenticate(null);
        message = result.getMessage();
        success = result.isSuccess();
        assert !success;
        assert message.equalsIgnoreCase("Failed");
    }

    @Test
    public void approvedLoanIndicator() {
      AccountController controller = new AccountController();
      boolean isUserEligible = controller.getApprovedLoanIndicator("1234");
      assert isUserEligible;
      isUserEligible = controller.getApprovedLoanIndicator(null);
      assert !isUserEligible;
    }


}
