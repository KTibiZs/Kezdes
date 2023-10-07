package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.general.Duration;

public class QuillAerialsLtd implements Operator {
    private static final String specNumber = "43";
    private static final double timeLimitInSec = 150;
    private static final double fixPriceUnderTimeLimit = 1.6;
    private static final double fixPriceAboveTimeLimit = 0.7;

    @Override
    public String getPricing() {
        return "az első 2:30 percben 1,60 peták/mp, azt követően 0,70 peták/mp";
    }

    @Override
    public String getOperatorName() {
        return "Quill Aerials Ltd.";
    }

    @Override
    public double getPrice(Duration duration) {


        double sec = duration.rawDurationToSec(duration.getRawDuration());
        double finalPrice = 0;
        if (sec > finalPrice) {
            finalPrice = (timeLimitInSec * fixPriceUnderTimeLimit) + ((sec - timeLimitInSec) * fixPriceAboveTimeLimit);
        } else {
            finalPrice = sec * fixPriceUnderTimeLimit;
        }
        return finalPrice;
    }

    @Override
    public String getOperatorSpecifyNumber() {
        return specNumber;
    }
}
