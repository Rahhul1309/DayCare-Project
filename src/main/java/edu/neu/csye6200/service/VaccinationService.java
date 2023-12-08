package edu.neu.csye6200.service;

import edu.neu.csye6200.model.Immunization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import edu.neu.csye6200.repository.VaccinationRepository;


@Service
public class VaccinationService {
    @Autowired
    VaccinationRepository vaccinationRepository;
    VaccinationFactory vf = new VaccinationFactory();

    public List<Immunization> getAllVaccinations() {
        List<Immunization> vaccinations = new ArrayList<>();
        if (vaccinationRepository.findAll().iterator().hasNext()) {
            vaccinationRepository.findAll().forEach(vaccinations::add);
        }
        return vaccinations;
    }

    public void saveVaccinations(List<Immunization> vaccinations) {
        vaccinationRepository.saveAll(vaccinations);
    }

    public void saveVaccinations(Immunization vaccination) {
        vaccinationRepository.save(vaccination);
    }

    public void saveVaccination(String csv) {
        vaccinationRepository.save(vf.getObject(csv));
    }

    public Optional<Immunization> getVaccinationById(Integer id) {
        return vaccinationRepository.findById(id);
    }

    public void deleteVaccinationsById(Integer id) {
        vaccinationRepository.deleteById(id);
    }

    public void deleteAll() {
        vaccinationRepository.deleteAll();
    }
}
