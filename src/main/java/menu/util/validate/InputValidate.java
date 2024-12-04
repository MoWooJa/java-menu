package menu.util.validate;

import menu.util.exception.ErrorMessage;

public class InputValidate {

    public static void validateInputCoachesCount(String[] arrCoaches) {
        int arrCoachesCount = arrCoaches.length;
        if (arrCoachesCount < 2 || arrCoachesCount > 5) {
            throw new IllegalArgumentException(ErrorMessage.NON_COACHES_COUNT_SIZE.getMessage());
        }
    }
}
