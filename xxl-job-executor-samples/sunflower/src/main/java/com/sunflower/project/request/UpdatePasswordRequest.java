package com.sunflower.project.request;

import com.sunflower.project.model.UserAccount;

public class UpdatePasswordRequest extends UserAccount {
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
