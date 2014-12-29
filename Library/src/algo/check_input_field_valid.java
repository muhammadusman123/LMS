package algo;

public class check_input_field_valid {



	 
	
    public boolean checkIfNumber(String in) {

        try {

            Integer.parseInt(in);

        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}