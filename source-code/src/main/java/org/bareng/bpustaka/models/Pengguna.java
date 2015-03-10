/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bareng.bpustaka.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Pengguna.findAll", query = "select p from Pengguna p"),
    @NamedQuery(name = "Pengguna.findById", query = "select p from Pengguna p where p.id = :id")})
public class Pengguna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "PenggunaPK_Generator", sequenceName = "pengguna_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Nama Pengguna Tidak Boleh Kosong")
    @Size(min = 4)
    private String username;

    @Column(length = 32)
    @NotNull(message = "Kata Sandi Tidak Boleh Kosong")
    @Size(min = 8, max = 32)
    private String password;

    @NotNull(message = "Nama Lengkap Tidak Boleh Kosong")
    @Size(min = 5)
    private String fullName;

    @NotNull(message = "Surel Tidak Boleh Kosong")
    @Size(min = 5)
    private String email;

    @NotNull(message = "Kontak Tidak Boleh Kosong")
    @Size(min = 5)
    private String kontak;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;

    public Pengguna() {
    }

    public Pengguna(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        ByteBuffer passwdBuffer = Charset.defaultCharset().encode(CharBuffer.wrap(password));
        byte[] passwdBytes = passwdBuffer.array();
        MessageDigest mdEnc = null;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
        }
        mdEnc.update(passwdBytes, 0, password.length());
        String oldPassword = this.password;
        this.password = new BigInteger(1, mdEnc.digest()).toString(16);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pengguna other = (Pengguna) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fullName;
    }

}
