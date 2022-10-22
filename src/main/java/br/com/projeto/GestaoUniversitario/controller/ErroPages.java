package br.com.projeto.GestaoUniversitario.controller;

import org.apache.http.HttpStatus;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErroPages implements ErrorController {
    @RequestMapping("naoAutorizado")
    public String naoAutorizado(Model model){

        model.addAttribute("naoAutorizado", true);
        return "erroPage";
    }

    @RequestMapping("error")
    public String erro(HttpServletRequest request,Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int codigo = Integer.parseInt(status.toString());

            if (codigo == HttpStatus.SC_NOT_FOUND) {
                model.addAttribute("notFound", true);
                return "erroPage";
            }else if (codigo == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    model.addAttribute("internalErro", true);
                return "erroPage";
            }else {
                model.addAttribute("codigoErro",codigo);
                model.addAttribute("outroErro",true);
                return "erroPage";
            }
        }

        return "erroPage";
    }


}
