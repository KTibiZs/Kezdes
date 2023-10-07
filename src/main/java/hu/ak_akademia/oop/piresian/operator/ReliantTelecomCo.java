package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.general.Duration;


public class ReliantTelecomCo implements Operator {
    private static final String specNumber = "711";
    private static final double pricePerMinute = 67;
    private static final double minuteInSec = 60;

    @Override
    public String getPricing() {
        return "megkezdett percenként 67 peták/perc";
    }

    @Override
    public String getOperatorName() {
        return "Reliant Telecom Co.";
    }

    @Override
    public double getPrice(Duration duration) {
        double sec = duration.rawDurationToSec(duration.getRawDuration());
        double finalPrice = (Math.floor(((sec / minuteInSec) * pricePerMinute)));

        if (finalPrice % minuteInSec != 0) {
            finalPrice = (Math.floor(((sec / minuteInSec) * pricePerMinute) + pricePerMinute));
        }
        return finalPrice;
    }

    @Override
    public String getOperatorSpecifyNumber() {
        return specNumber;
    }
}
