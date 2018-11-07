package tasks;

import java.util.ArrayList;

public class Park {

    private class Info {
        private ArrayList<String> nameOfAttraction;
        private ArrayList<String> workingHours;
        private int cost;

        private Info(ArrayList<String> nameOfAttraction, ArrayList<String> workingHours, int cost) {
            this.nameOfAttraction = nameOfAttraction;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public ArrayList<String> getNameOfAttraction() {
            return nameOfAttraction;
        }

        public void setNameOfAttraction(ArrayList<String> nameOfAttraction) {
            this.nameOfAttraction = nameOfAttraction;
        }

        public ArrayList<String> getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(ArrayList<String> workingHours) {
            this.workingHours = workingHours;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
