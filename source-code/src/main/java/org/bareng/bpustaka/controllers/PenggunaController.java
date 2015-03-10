/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bareng.bpustaka.controllers;

import java.util.List;
import org.bareng.bpustaka.services.PenggunaService;
import org.bareng.bpustaka.models.Pengguna;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author DAWUD
 */
public class PenggunaController implements Controller {

    private PenggunaService penggunaService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        List<Pengguna> users = penggunaService.findAll();
        ModelAndView modelAndView = new ModelAndView("pengguna/list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    public void setPenggunaService(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

}
