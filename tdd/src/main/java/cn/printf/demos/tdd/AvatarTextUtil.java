package cn.printf.demos.tdd;

public class AvatarTextUtil {
    public static String generateDefaultAvatarText(User user) {
        if (null != user.getCnName()) {
            String userName = user.getCnName();
            return userName.substring(userName.length() - 2);
        }
        if (null != user.getEnName()) {
            String userName = user.getEnName();
            return userName.substring(0, 1).toUpperCase();
        }
        return null;
    }

}
