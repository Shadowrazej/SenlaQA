package tasks;

import java.util.ArrayList;

public class Cinema {

    private class Info {
        private ArrayList<String> address;
        private ArrayList<String> movieTitle;
        private ArrayList<String> startTime;

        private Info(ArrayList<String> address, ArrayList<String> movieTitle, ArrayList<String> startTime) {
            this.address = address;
            this.movieTitle = movieTitle;
            this.startTime = startTime;
        }

        public ArrayList<String> getAddress() {
            return address;
        }

        public void setAddress(ArrayList<String> address) {
            this.address = address;
        }

        public ArrayList<String> getMovieTitle() {
            return movieTitle;
        }

        public void setMovieTitle(ArrayList<String> movieTitle) {
            this.movieTitle = movieTitle;
        }

        public ArrayList<String> getStartTime() {
            return startTime;
        }

        public void setStartTime(ArrayList<String> startTime) {
            this.startTime = startTime;
        }
    }
}
