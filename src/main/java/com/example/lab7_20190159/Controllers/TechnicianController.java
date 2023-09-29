package com.example.lab7_20190159.Controllers;

import com.example.lab7_20190159.entities.Technician;
import com.example.lab7_20190159.repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tecnicos")
public class TechnicianController {

    final TechnicianRepository technicianRepository;

    public TechnicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"/lista"})
    public String lista(Model model){

        model.addAttribute("listaTecnicos", technicianRepository.findAll());

        return "Tecnicos/lista";
    }



    @GetMapping("/new")
    public String nuevoProductoFrm(Model model, @ModelAttribute("tecnico") Technician technician) {

        return "Tecnicos/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            if (technician.getId() == 0) {
                attr.addFlashAttribute("msg", "Tecnico creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Tecnico actualizado exitosamente");
            }
            technicianRepository.save(technician);
            return "redirect:/tecnicos/lista";


        } else { //hay al menos 1 error
            //model.addAttribute("listaCategorias", categoryRepository.findAll());
            //model.addAttribute("listaProveedores", supplierRepository.findAll());
            return "Tecnicos/editFrm";
        }
    }

    @GetMapping("/editar")
    public String editarTransportista(@ModelAttribute("product") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("tecnico", technician);

            return "Tecnicos/editFrm";
        } else {
            return "redirect:/tecnicos/lista";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(@RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            technicianRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Tecnico borrado exitosamente");
        }
        return "redirect:/tecnicos/lista";

    }
}
