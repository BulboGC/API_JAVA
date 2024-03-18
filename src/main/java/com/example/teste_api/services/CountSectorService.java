package com.example.teste_api.services;

import com.example.teste_api.models.CountSectorModel;
import com.example.teste_api.repositories.CountSectorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountSectorService {
    @Autowired
    CountSectorRepository countSectorRepository;




    public CountSectorModel createSectorCount(UUID levelId,String sector){

       Optional<CountSectorModel> sectorCount = countSectorRepository.findById(levelId);
       if(sectorCount.isEmpty()){
           CountSectorModel model = new CountSectorModel(levelId,sector);
          return countSectorRepository.save(model);
       }
       else{
           throw new Error("o id informado já está cadastrado no sistema");
       }
    }




    @Transactional
    public List<CountSectorModel> changeSectorCount(UUID id, UUID newId) {
        List<UUID> uuids = new ArrayList<>();
        uuids.add(id);
        uuids.add(newId);

        List<CountSectorModel> counts = countSectorRepository.findAllByIdIn(uuids);

        if (!id.equals(newId)) {
            counts.forEach((CountSectorModel model) -> {
                if (id.equals(model.getId())) {
                    model.decrement();
                }
                model.increment();
            });

            return countSectorRepository.saveAll(counts);

        }else {

            List<CountSectorModel> list = new ArrayList<CountSectorModel>();
            counts.forEach((CountSectorModel model)->{
                model.increment();

                CountSectorModel countSaved =  countSectorRepository.save(model);
                list.add(countSaved);

                });

            return list;
            }

    }
}
