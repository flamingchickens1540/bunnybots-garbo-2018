package org.team1540.garbo_code;

import java.util.HashMap;

public class Ramping {

    HashMap<Integer, Double> motorValues;

    public Ramping() {

        motorValues = new HashMap<Integer, Double>();

    }

    public double doRamping(int id, double input, double rampingConstant) {

        double output;

        if (!motorValues.containsKey(id)) {

            motorValues.put(id, 0.0);

        }

        if (Math.abs(input - motorValues.get(id)) < rampingConstant) {

            output = input;

        } else {

            output = motorValues.get(id) + rampingConstant * Math.signum(input - motorValues.get(id));

        }

        motorValues.put(id, output);

        return output;

    }

}
