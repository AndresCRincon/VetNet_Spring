package com.example.vetnet.entidad;

import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.vetnet.repositorio.ClienteRepository;
import com.example.vetnet.repositorio.DrogaRepository;
import com.example.vetnet.repositorio.MascotaRepository;
import com.example.vetnet.repositorio.TratamientoRepository;
import com.example.vetnet.repositorio.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    DrogaRepository drogaRepository;

    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clienteRepository.save(new Cliente("pepe","pepe1234","pepe@gmail.com",123456789,923874920));
        clienteRepository.save(new Cliente("gustavo uribe", "gustavo1234","centrohumano@yahoo.com", 246810, 393487493));
        clienteRepository.save(new Cliente("James Rodriguez", "james1234","james@hotmail.com", 409856765, 43948435));
        clienteRepository.save(new Cliente("Don Juan", "juan1234","juanitojuan@gmail.com", 349843345, 95867956));
        clienteRepository.save(new Cliente("juan","juan1234","juan@gmail.com",12345678,923874921));
/*clienteRepository.save(new Cliente("maria","maria1234","maria@gmail.com",23456789,923874922));
clienteRepository.save(new Cliente("luis","luis1234","luis@gmail.com",34567891,923874923));
clienteRepository.save(new Cliente("ana","ana1234","ana@gmail.com",45678912,923874924));
clienteRepository.save(new Cliente("pedro","pedro1234","pedro@gmail.com",56789123,923874925));
clienteRepository.save(new Cliente("sofia","sofia1234","sofia@gmail.com",67891234,923874926));
clienteRepository.save(new Cliente("carla","carla1234","carla@gmail.com",78912345,923874927));
clienteRepository.save(new Cliente("jorge","jorge1234","jorge@gmail.com",89123456,923874928));
clienteRepository.save(new Cliente("lucia","lucia1234","lucia@gmail.com",91234567,923874929));
clienteRepository.save(new Cliente("diego","diego1234","diego@gmail.com",12345678,923874930));
clienteRepository.save(new Cliente("elena","elena1234","elena@gmail.com",23456789,923874931));
clienteRepository.save(new Cliente("alejandro","alejandro1234","alejandro@gmail.com",34567891,923874932));
clienteRepository.save(new Cliente("paula","paula1234","paula@gmail.com",45678912,923874933));
clienteRepository.save(new Cliente("roberto","roberto1234","roberto@gmail.com",56789123,923874934));
clienteRepository.save(new Cliente("adriana","adriana1234","adriana@gmail.com",67891234,923874935));
clienteRepository.save(new Cliente("andres","andres1234","andres@gmail.com",78912345,923874936));
clienteRepository.save(new Cliente("flor","flor1234","flor@gmail.com",89123456,923874937));
clienteRepository.save(new Cliente("daniel","daniel1234","daniel@gmail.com",91234567,923874938));
clienteRepository.save(new Cliente("fernando","fernando1234","fernando@gmail.com",12345678,923874939));
clienteRepository.save(new Cliente("valeria","valeria1234","valeria@gmail.com",23456789,923874940));
clienteRepository.save(new Cliente("carlos","carlos1234","carlos@gmail.com",34567891,923874941));
clienteRepository.save(new Cliente("camila","camila1234","camila@gmail.com",45678912,923874942));
clienteRepository.save(new Cliente("javier","javier1234","javier@gmail.com",56789123,923874943));
clienteRepository.save(new Cliente("natalia","natalia1234","natalia@gmail.com",67891234,923874944));
clienteRepository.save(new Cliente("sergio","sergio1234","sergio@gmail.com",78912345,923874945));
clienteRepository.save(new Cliente("claudia","claudia1234","claudia@gmail.com",89123456,923874946));
clienteRepository.save(new Cliente("antonio","antonio1234","antonio@gmail.com",91234567,923874947));
clienteRepository.save(new Cliente("mariana","mariana1234","mariana@gmail.com",12345678,923874948));
clienteRepository.save(new Cliente("eduardo","eduardo1234","eduardo@gmail.com",23456789,923874949));
clienteRepository.save(new Cliente("alicia","alicia1234","alicia@gmail.com",34567891,923874950));
clienteRepository.save(new Cliente("pablo","pablo1234","pablo@gmail.com",45678912,923874951));
clienteRepository.save(new Cliente("monica","monica1234","monica@gmail.com",56789123,923874952));
clienteRepository.save(new Cliente("hugo","hugo1234","hugo@gmail.com",67891234,923874953));
clienteRepository.save(new Cliente("irene","irene1234","irene@gmail.com",78912345,923874954));
clienteRepository.save(new Cliente("gonzalo","gonzalo1234","gonzalo@gmail.com",89123456,923874955));
clienteRepository.save(new Cliente("veronica","veronica1234","veronica@gmail.com",91234567,923874956));
clienteRepository.save(new Cliente("marcos","marcos1234","marcos@gmail.com",12345678,923874957));
clienteRepository.save(new Cliente("juliana","juliana1234","juliana@gmail.com",23456789,923874958));
clienteRepository.save(new Cliente("francisco","francisco1234","francisco@gmail.com",34567891,923874959));
clienteRepository.save(new Cliente("isabel","isabel1234","isabel@gmail.com",45678912,923874960));
clienteRepository.save(new Cliente("rafael","rafael1234","rafael@gmail.com",56789123,923874961));
clienteRepository.save(new Cliente("lara","lara1234","lara@gmail.com",67891234,923874962));
clienteRepository.save(new Cliente("manuela","manuela1234","manuela@gmail.com",78912345,923874963));
clienteRepository.save(new Cliente("martin","martin1234","martin@gmail.com",89123456,923874964));
clienteRepository.save(new Cliente("gisela","gisela1234","gisela@gmail.com",91234567,923874965));
clienteRepository.save(new Cliente("matias","matias1234","matias@gmail.com",12345678,923874966));
clienteRepository.save(new Cliente("patricia","patricia1234","patricia@gmail.com",23456789,923874967));
clienteRepository.save(new Cliente("santiago","santiago1234","santiago@gmail.com",34567891,923874968));
clienteRepository.save(new Cliente("emilia","emilia1234","emilia@gmail.com",45678912,923874969));
clienteRepository.save(new Cliente("marcelo","marcelo1234","marcelo@gmail.com",56789123,923874970));
clienteRepository.save(new Cliente("soledad","soledad1234","soledad@gmail.com",67891234,923874971));
clienteRepository.save(new Cliente("fabian","fabian1234","fabian@gmail.com",78912345,923874972));
clienteRepository.save(new Cliente("beatriz","beatriz1234","beatriz@gmail.com",89123456,923874973));
clienteRepository.save(new Cliente("damian","damian1234","damian@gmail.com",91234567,923874974));
clienteRepository.save(new Cliente("tamara","tamara1234","tamara@gmail.com",12345678,923874975));
clienteRepository.save(new Cliente("alfredo","alfredo1234","alfredo@gmail.com",23456789,923874976));
clienteRepository.save(new Cliente("miriam","miriam1234","miriam@gmail.com",34567891,923874977));
clienteRepository.save(new Cliente("ramiro","ramiro1234","ramiro@gmail.com",45678912,923874978));
clienteRepository.save(new Cliente("graciela","graciela1234","graciela@gmail.com",56789123,923874979));
clienteRepository.save(new Cliente("pilar","pilar1234","pilar@gmail.com",67891234,923874980));
clienteRepository.save(new Cliente("joaquin","joaquin1234","joaquin@gmail.com",78912345,923874981));
clienteRepository.save(new Cliente("reina","reina1234","reina@gmail.com",89123456,923874982));
clienteRepository.save(new Cliente("felipe","felipe1234","felipe@gmail.com",91234567,923874983));
clienteRepository.save(new Cliente("milena","milena1234","milena@gmail.com",12345678,923874984));
clienteRepository.save(new Cliente("oscar","oscar1234","oscar@gmail.com",23456789,923874985));
clienteRepository.save(new Cliente("violeta","violeta1234","violeta@gmail.com",34567891,923874986));
clienteRepository.save(new Cliente("miguel","miguel1234","miguel@gmail.com",45678912,923874987));
clienteRepository.save(new Cliente("martina","martina1234","martina@gmail.com",56789123,923874988));
clienteRepository.save(new Cliente("enrique","enrique1234","enrique@gmail.com",67891234,923874989));
clienteRepository.save(new Cliente("belen","belen1234","belen@gmail.com",78912345,923874990));
clienteRepository.save(new Cliente("ricardo","ricardo1234","ricardo@gmail.com",89123456,923874991));
clienteRepository.save(new Cliente("eva","eva1234","eva@gmail.com",91234567,923874992));
clienteRepository.save(new Cliente("humberto","humberto1234","humberto@gmail.com",12345678,923874993));
clienteRepository.save(new Cliente("leon","leon1234","leon@gmail.com",23456789,923874994));
clienteRepository.save(new Cliente("matilde","matilde1234","matilde@gmail.com",34567891,923874995));
clienteRepository.save(new Cliente("bruno","bruno1234","bruno@gmail.com",45678912,923874996));
clienteRepository.save(new Cliente("rosa","rosa1234","rosa@gmail.com",56789123,923874997));
clienteRepository.save(new Cliente("sebastian","sebastian1234","sebastian@gmail.com",67891234,923874998));
clienteRepository.save(new Cliente("carolina","carolina1234","carolina@gmail.com",78912345,923874999));
clienteRepository.save(new Cliente("angel","angel1234","angel@gmail.com",89123456,923875000)); */
        

        mascotaRepository.save(new Mascota("Rex", "25kg", "Pastor Alemán", "Ninguna", "Activo", 5, "./img/jhony.jpg"));
        mascotaRepository.save(new Mascota("Luna", "8kg", "Chihuahua", "Catarro", "Enferma", 3, "./img/Zeus.jpg"));
        mascotaRepository.save(new Mascota("Pablo", "30kg", "Labrador", "Problemas de piel", "Activo", 7, "./img/pablo.jpg"));
        mascotaRepository.save(new Mascota("Bella", "12kg", "Beagle", "Alérgica a los alimentos", "Recuperándose", 4, "./img/lucas.jpg"));
        mascotaRepository.save(new Mascota("Charlie", "20kg", "Bulldog Francés", "Ninguna", "Activo", 6, "./img/miguel.jpg"));
        mascotaRepository.save(new Mascota("Max", "25kg", "Pastor Alemán", "Ninguna", "Activo", 5, "./img/max.jpg"));
/*mascotaRepository.save(new Mascota("Bella", "20kg", "Labrador", "Alergias", "Juguetona", 3, "/img/bella.jpg"));
mascotaRepository.save(new Mascota("Charlie", "22kg", "Beagle", "Ninguna", "Curioso", 4, "https://example.com/charlie.jpg"));
mascotaRepository.save(new Mascota("Lucy", "15kg", "Golden Retriever", "Displasia", "Amigable", 6, "https://example.com/lucy.jpg"));
mascotaRepository.save(new Mascota("Rocky", "30kg", "Rottweiler", "Ninguna", "Protector", 7, "/img/rocky.jpg"));
mascotaRepository.save(new Mascota("Daisy", "18kg", "Bulldog", "Dermatitis", "Tranquila", 2, "https://example.com/daisy.jpg"));
mascotaRepository.save(new Mascota("Milo", "12kg", "Cocker Spaniel", "Ninguna", "Cariñoso", 4, "/img/milo.jpg"));
mascotaRepository.save(new Mascota("Luna", "22kg", "Schnauzer", "Alergias", "Viva", 5, "/img/luna.jpg"));
mascotaRepository.save(new Mascota("Toby", "25kg", "Boxer", "Ninguna", "Activo", 5, "https://example.com/toby.jpg"));
mascotaRepository.save(new Mascota("Chloe", "16kg", "Poodle", "Ninguna", "Tranquila", 3, "/img/chloe.jpg"));
mascotaRepository.save(new Mascota("Buddy", "28kg", "Husky Siberiano", "Ninguna", "Energético", 6, "/img/buddy.jpg"));
mascotaRepository.save(new Mascota("Zoey", "23kg", "Border Collie", "Alergias", "Juguetona", 4, "/img/zoey.jpg"));
mascotaRepository.save(new Mascota("Oscar", "27kg", "Dálmata", "Ninguna", "Curioso", 5, "https://example.com/oscar.jpg"));
mascotaRepository.save(new Mascota("Molly", "13kg", "Shih Tzu", "Ninguna", "Amigable", 3, "https://example.com/molly.jpg"));
mascotaRepository.save(new Mascota("Simba", "22kg", "Pastor Belga", "Ninguna", "Protector", 7, "/img/simba.jpg"));
mascotaRepository.save(new Mascota("Bailey", "20kg", "Samoyedo", "Ninguna", "Juguetón", 4, "/img/bailey.jpg"));
mascotaRepository.save(new Mascota("Coco", "14kg", "Dachshund", "Displasia", "Curioso", 6, "https://example.com/coco.jpg"));
mascotaRepository.save(new Mascota("Buster", "26kg", "San Bernardo", "Alergias", "Amigable", 5, "/img/buster.jpg"));
mascotaRepository.save(new Mascota("Ginger", "21kg", "Setter Irlandés", "Ninguna", "Activo", 3, "https://example.com/ginger.jpg"));
mascotaRepository.save(new Mascota("Duke", "29kg", "Gran Danés", "Ninguna", "Protector", 4, "/img/duke.jpg"));
mascotaRepository.save(new Mascota("Ruby", "19kg", "Corgi", "Ninguna", "Juguetona", 2, "https://example.com/ruby.jpg"));
mascotaRepository.save(new Mascota("Rex", "25kg", "Pastor Alemán", "Ninguna", "Activo", 5, "/img/jhony.jpg"));
mascotaRepository.save(new Mascota("Bingo", "20kg", "Basset Hound", "Ninguna", "Curioso", 4, "/img/bingo.jpg"));
mascotaRepository.save(new Mascota("Shadow", "23kg", "Alaskan Malamute", "Ninguna", "Protector", 6, "https://example.com/shadow.jpg"));
mascotaRepository.save(new Mascota("Maggie", "17kg", "Chihuahua", "Alergias", "Nerviosa", 2, "/img/maggie.jpg"));
mascotaRepository.save(new Mascota("Zoe", "18kg", "Yorkshire Terrier", "Ninguna", "Juguetona", 3, "/img/zoe.jpg"));
mascotaRepository.save(new Mascota("Sam", "24kg", "Pug", "Ninguna", "Tranquilo", 4, "https://example.com/sam.jpg"));
mascotaRepository.save(new Mascota("Layla", "19kg", "Jack Russell Terrier", "Ninguna", "Energética", 3, "/img/layla.jpg"));
mascotaRepository.save(new Mascota("Apollo", "30kg", "Pitbull", "Alergias", "Protector", 6, "/img/apollo.jpg"));
mascotaRepository.save(new Mascota("Mia", "16kg", "Terranova", "Ninguna", "Amigable", 5, "https://example.com/mia.jpg"));
mascotaRepository.save(new Mascota("Riley", "21kg", "Akita", "Ninguna", "Curioso", 4, "/img/riley.jpg"));
mascotaRepository.save(new Mascota("Rosie", "15kg", "Maltés", "Ninguna", "Juguetona", 2, "https://example.com/rosie.jpg"));
mascotaRepository.save(new Mascota("Jack", "28kg", "Doberman", "Ninguna", "Protector", 5, "/img/jack.jpg"));
mascotaRepository.save(new Mascota("Gracie", "22kg", "Fox Terrier", "Ninguna", "Energética", 4, "/img/gracie.jpg"));
mascotaRepository.save(new Mascota("Jasper", "25kg", "Vizsla", "Ninguna", "Juguetón", 6, "https://example.com/jasper.jpg"));
mascotaRepository.save(new Mascota("Lily", "20kg", "Cocker Spaniel", "Alergias", "Tranquila", 3, "/img/lily.jpg"));
mascotaRepository.save(new Mascota("Rocco", "27kg", "Labrador", "Ninguna", "Protector", 6, "/img/rocco.jpg"));
mascotaRepository.save(new Mascota("Bruno", "29kg", "Mastín", "Ninguna", "Activo", 5, "https://example.com/bruno.jpg"));
mascotaRepository.save(new Mascota("Nala", "14kg", "Husky", "Ninguna", "Curiosa", 3, "/img/nala.jpg"));
mascotaRepository.save(new Mascota("Leo", "18kg", "Pomerania", "Ninguna", "Amigable", 4, "/img/leo.jpg"));
mascotaRepository.save(new Mascota("Kira", "21kg", "Setter", "Displasia", "Juguetona", 5, "https://example.com/kira.jpg"));
mascotaRepository.save(new Mascota("Ace", "24kg", "Border Collie", "Alergias", "Protector", 3, "/img/ace.jpg"));
mascotaRepository.save(new Mascota("Blue", "26kg", "Golden Retriever", "Ninguna", "Juguetón", 5, "https://example.com/blue.jpg"));
*/
veterinarioRepository.save(new Veterinario("Fernando","fernando1234","Cirugia",24681012,3,"https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg"));
veterinarioRepository.save(new Veterinario("Laura","laura1234","Farmacologia",11111111,8,"https://img.freepik.com/foto-gratis/doctora-vistiendo-bata-laboratorio-estetoscopio-aislado_1303-29791.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1726531200&semt=ais_hybrid"));
veterinarioRepository.save(new Veterinario("Carlos", "carlos1234", "Dermatología", 98765432, 5, "https://www.shutterstock.com/image-photo/portrait-smiling-male-doctor-standing-600nw-1234848211.jpg"));
veterinarioRepository.save(new Veterinario("Ana", "ana1234", "Neurología", 24681357, 4, "https://img.freepik.com/foto-gratis/enfermera-retrato-aislado-estudio_1303-29634.jpg?size=626&ext=jpg"));
veterinarioRepository.save(new Veterinario("Miguel", "miguel1234", "Oncología", 12345678, 6, "https://www.shutterstock.com/image-photo/portrait-smiling-female-doctor-600nw-758594246.jpg"));
veterinarioRepository.save(new Veterinario("Sofia", "sofia1234", "Cardiología", 55566677, 7, "https://www.shutterstock.com/image-photo/portrait-confident-young-female-doctor-600nw-1197014515.jpg"));
veterinarioRepository.save(new Veterinario("Andres", "andres1234", "Oftalmología", 88899900, 2, "https://img.freepik.com/foto-gratis/retrato-medico-confianza_329181-6656.jpg?size=626&ext=jpg"));
veterinarioRepository.save(new Veterinario("Gabriela", "gabriela1234", "Endocrinología", 32165487, 10, "https://www.shutterstock.com/image-photo/portrait-smiling-young-woman-doctor-600nw-2163539789.jpg"));
veterinarioRepository.save(new Veterinario("Javier", "javier1234", "Traumatología", 98712345, 12, "https://www.shutterstock.com/image-photo/portrait-smiling-mature-male-doctor-600nw-756205785.jpg"));
veterinarioRepository.save(new Veterinario("Lucía", "lucia1234", "Ginecología", 77788899, 9, "https://www.shutterstock.com/image-photo/portrait-smiling-female-doctor-600nw-1938421528.jpg"));
veterinarioRepository.save(new Veterinario("Pablo", "pablo1234", "Cirugia", 66677788, 11, "https://www.shutterstock.com/image-photo/portrait-young-male-doctor-crossing-600nw-1444216072.jpg"));
veterinarioRepository.save(new Veterinario("Elena", "elena1234", "Anestesiología", 12348765, 14, "https://www.shutterstock.com/image-photo/portrait-smiling-female-nurse-isolated-600nw-1720672754.jpg"));
veterinarioRepository.save(new Veterinario("Roberto", "roberto1234", "Patología", 95175342, 3, "https://img.freepik.com/foto-gratis/retrato-joven-doctor_1303-29793.jpg?size=626&ext=jpg"));
veterinarioRepository.save(new Veterinario("Marta", "marta1234", "Rehabilitación", 14725836, 13, "https://www.shutterstock.com/image-photo/young-doctor-isolated-600nw-171779937.jpg"));
veterinarioRepository.save(new Veterinario("Valeria", "valeria1234", "Nutrición", 75395126, 6, "https://img.freepik.com/foto-gratis/medico-aislado_1303-29722.jpg?size=626&ext=jpg"));
veterinarioRepository.save(new Veterinario("David", "david1234", "Infectología", 12365478, 1, "https://www.shutterstock.com/image-photo/portrait-young-male-doctor-crossing-600nw-1984612242.jpg"));
veterinarioRepository.save(new Veterinario("Isabel", "isabel1234", "Urgencias", 96325874, 15, "https://www.shutterstock.com/image-photo/female-doctor-holding-clipboard-looking-600nw-1912046763.jpg"));
veterinarioRepository.save(new Veterinario("Joaquín", "joaquin1234", "Cirugía general", 78945612, 4, "https://img.freepik.com/foto-gratis/joven-doctor-vistiendo-bata-laboratorio-estetoscopio_1303-29792.jpg?size=626&ext=jpg"));
veterinarioRepository.save(new Veterinario("Patricia", "patricia1234", "Radiología", 85296374, 5, "https://www.shutterstock.com/image-photo/portrait-young-beautiful-doctor-isolated-600nw-171779968.jpg"));
veterinarioRepository.save(new Veterinario("Alberto", "alberto1234", "Toxicología", 15935748, 8, "https://www.shutterstock.com/image-photo/portrait-mature-handsome-doctor-600nw-2112511542.jpg"));


drogaRepository.save(new Droga("Propofol", 10500.05f, 150000.0f, 10, 20));
drogaRepository.save(new Droga("Fentanilo", 8500.30f, 120000.0f, 15, 25));
drogaRepository.save(new Droga("Midazolam", 5000.00f, 90000.0f, 12, 18));
drogaRepository.save(new Droga("Ketamina", 9500.10f, 140000.0f, 8, 16));
drogaRepository.save(new Droga("Lidocaína", 3500.75f, 55000.0f, 20, 30));
drogaRepository.save(new Droga("Morfina", 7800.40f, 110000.0f, 14, 22));
drogaRepository.save(new Droga("Diazepam", 4200.50f, 60000.0f, 18, 28));
drogaRepository.save(new Droga("Etomidato", 6200.20f, 95000.0f, 9, 19));
drogaRepository.save(new Droga("Suxametonio", 3200.00f, 45000.0f, 25, 35));
drogaRepository.save(new Droga("Rocuronio", 6800.65f, 99000.0f, 11, 21));

tratamientoRepository.save(new Tratamiento(drogaRepository.findById(1L).get(), generarFechaAleatoria(), mascotaRepository.findById(5L).get(), veterinarioRepository.findById(3L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(2L).get(), generarFechaAleatoria(), mascotaRepository.findById(2L).get(),veterinarioRepository.findById(2L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(3L).get(), generarFechaAleatoria(), mascotaRepository.findById(3L).get(),veterinarioRepository.findById(1L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(4L).get(), generarFechaAleatoria(), mascotaRepository.findById(4L).get(),veterinarioRepository.findById(16L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(5L).get(), generarFechaAleatoria(), mascotaRepository.findById(5L).get(),veterinarioRepository.findById(4L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(6L).get(), generarFechaAleatoria(), mascotaRepository.findById(4L).get(),veterinarioRepository.findById(1L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(7L).get(), generarFechaAleatoria(), mascotaRepository.findById(1L).get(),veterinarioRepository.findById(12L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(8L).get(), generarFechaAleatoria(), mascotaRepository.findById(2L).get(),veterinarioRepository.findById(18L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(9L).get(), generarFechaAleatoria(), mascotaRepository.findById(2L).get(),veterinarioRepository.findById(12L).get()));
tratamientoRepository.save(new Tratamiento(drogaRepository.findById(10L).get(), generarFechaAleatoria(), mascotaRepository.findById(3L).get(),veterinarioRepository.findById(5L).get()));



        Cliente asociar = clienteRepository.findById(clienteRepository.findAll().get(0).getId()).get();
        for(Mascota mascot: mascotaRepository.findAll()){
            mascot.setCliente(asociar);
            mascotaRepository.save(mascot);
        }

        int cant_mascotas = mascotaRepository.findAll().size();
        for(Cliente cliente : clienteRepository.findAll()){
            for(int i=0; i<2; i++){
                int random = ThreadLocalRandom.current().nextInt(1,cant_mascotas+1);
                Long rand = Long.valueOf(random);
                Mascota mascot = mascotaRepository.findById(rand).get();
                mascot.setCliente(cliente);
                mascotaRepository.save(mascot);
            }
        }
    }

    private Date generarFechaAleatoria() {
        long minDay = Date.valueOf("2023-01-01").toLocalDate().toEpochDay();
        long maxDay = Date.valueOf("2023-12-31").toLocalDate().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return Date.valueOf(LocalDate.ofEpochDay(randomDay));
    }
    
}
