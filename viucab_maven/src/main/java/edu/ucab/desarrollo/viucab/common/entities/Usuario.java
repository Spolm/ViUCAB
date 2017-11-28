package edu.ucab.desarrollo.viucab.common.entities;

import java.awt.*;


/**
 * Created by estefania on 20/11/2017.
 */
public class Usuario {
    private int     _id_user;
    private String  _name_user;
    private String  _pass_user;
    private boolean _user_token;
    private String  _email_user;
    private Image _avatar_user;

    public Usuario(int _id_user, String _name_user, String _pass_user, boolean _user_token, String _email_user, Image _avatar_user) {
        this._id_user = _id_user;
        this._name_user = _name_user;
        this._pass_user = _pass_user;
        this._user_token = _user_token;
        this._email_user = _email_user;
        this._avatar_user = _avatar_user;
    }


    public Usuario(String _name_user) {
        this._name_user = _name_user;
    }

    public Usuario(int _id_user) {
        this._id_user = _id_user;
    }

    public Usuario() {
    }

    public int get_id_user() {
        return _id_user;
    }

    public void set_id_user(int _id_user) {
        this._id_user = _id_user;
    }

    public String get_name_user() {
        return _name_user;
    }

    public void set_name_user(String _name_user) {
        this._name_user = _name_user;
    }

    public String get_pass_user() {
        return _pass_user;
    }

    public void set_pass_user(String _pass_user) {
        this._pass_user = _pass_user;
    }

    public boolean is_user_token() {
        return _user_token;
    }

    public void set_user_token(boolean _user_token) {
        this._user_token = _user_token;
    }

    public String get_email_user() {
        return _email_user;
    }

    public void set_email_user(String _email_user) {
        this._email_user = _email_user;
    }

    public Image get_avatar_user() {
        return _avatar_user;
    }

    public void set_avatar_user(Image _avatar_user) {
        this._avatar_user = _avatar_user;
    }
}

