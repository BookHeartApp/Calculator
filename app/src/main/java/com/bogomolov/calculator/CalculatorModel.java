package com.bogomolov.calculator;

public class CalculatorModel {

    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private int spaceTable = 0;

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

    public void onNumberPressed(int buttonId) {

        if (state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId){
                case R.id.button_0:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.button_1:
                    inputStr.append("1");
                    break;
                case R.id.button_2:
                    inputStr.append("2");
                    break;
                case R.id.button_3:
                    inputStr.append("3");
                    break;
                case R.id.button_4:
                    inputStr.append("4");
                    break;
                case R.id.button_5:
                    inputStr.append("5");
                    break;
                case R.id.button_6:
                    inputStr.append("6");
                    break;
                case R.id.button_7:
                    inputStr.append("7");
                    break;
                case R.id.button_8:
                    inputStr.append("8");
                    break;
                case R.id.button_9:
                    inputStr.append("9");
                    break;

            }
        }
    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.button_result && state == State.secondArgInput) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.button_plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.button_minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.button_multiplication:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.button_division:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.button_ac:
                    inputStr.append(firstArg == 0 && secondArg == 0);
                    break;
            }
        }
        else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.button_plus:
                    actionSelected = R.id.button_plus;
                    break;
                case R.id.button_minus:
                    actionSelected = R.id.button_minus;
                    break;
                case R.id.button_multiplication:
                    actionSelected = R.id.button_multiplication;
                    break;
                case R.id.button_division:
                    actionSelected = R.id.button_division;
                    break;
                case R.id.button_ac:
                    actionSelected = R.id.button_ac;
                    break;
                case R.id.button_result:
                    actionSelected = R.id.button_result;
                    break;
            }
        }
        else if (actionId == R.id.button_ac) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            }
        }

    public String getText () {
        return inputStr.toString();
    }
}
