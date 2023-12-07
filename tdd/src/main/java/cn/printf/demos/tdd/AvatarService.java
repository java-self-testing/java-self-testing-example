package cn.printf.demos.tdd;

import java.awt.*;

import static cn.printf.demos.tdd.AvatarTextUtil.generateDefaultAvatarText;
import static cn.printf.demos.tdd.ImageUtil.watermarkImage;

public class AvatarService {

    public String generateUserDefaultAvatar(User user) {
        String avatarText = generateDefaultAvatarText(user);
        if ("male".equals(user.getGender())) {
            return watermarkImage(avatarText, Color.BLUE);
        }
        if ("female".equals(user.getGender())) {
            return watermarkImage(avatarText, Color.RED);
        }
        return watermarkImage(avatarText, Color.gray);
    }
}
