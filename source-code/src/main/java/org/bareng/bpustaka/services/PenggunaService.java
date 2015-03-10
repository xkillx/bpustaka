/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bareng.bpustaka.services;

import org.bareng.bpustaka.models.Pengguna;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DAWUD
 */
@Transactional
public class PenggunaService {

    private EntityManager koneksi;

    @Transactional(readOnly = true)
    public List<Pengguna> findAll() {
        return koneksi.createNamedQuery("Pengguna.findAll", Pengguna.class).getResultList();
    }

    public void setKoneksi(EntityManager koneksi) {
        this.koneksi = koneksi;
    }

}
