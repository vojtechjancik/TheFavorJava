package thefavor;

public enum FavorEnum {
    Input {
        @Override
        public String toString() {
            return "Input";
        }
    },
    Output {
        @Override
        public String toString() {
            return "Output";
        }
    }
}
