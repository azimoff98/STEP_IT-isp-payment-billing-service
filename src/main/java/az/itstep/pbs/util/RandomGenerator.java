package az.itstep.pbs.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {


    public String generateSubscriptionNumber(){
        return RandomStringUtils.random(12, true, true).toUpperCase();
    }

    public String generateRrn(){
        return RandomStringUtils.random(15, false, true);
    }

}
