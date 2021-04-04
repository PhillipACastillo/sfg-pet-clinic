package guru.springframework.sfgpetclinic.controllers.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import jdk.jfr.Percentage;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.sfgpetclinic.services.OwnerService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    public final VetService vetService;
    public final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jordan");
        owner1.setAddress("123 Main St.");
        owner1.setCity("Monrovia");
        owner1.setTelephone("6263595856");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Milo");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gertrude");
        owner2.setLastName("Stein");
        owner2.setAddress("123. Lemon Ave.");
        owner2.setCity("Santa Cruz");
        owner2.setTelephone("5555876309");

        Pet gersCat = new Pet();
        gersCat.setPetType(savedDogPetType);
        gersCat.setName("Trudy");
        gersCat.setOwner(owner2);
        gersCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(gersCat);

        ownerService.save(owner2);

        System.out.println("Load Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("House");
        vet1.setLastName("MD");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Walter");
        vet2.setLastName("White");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
