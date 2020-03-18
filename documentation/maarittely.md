#Mitä algoritmeja ja tietorakenteita toteutat työssäsi
##Tietorakenteet
Ainakin alustavasti suunnittelen käyttäväni hajautuskarttaa pelilaudan ja sen tilan tallentamiseen.
Kunkin pelilaudan heksan tila tallennetaan sitä vastaavaan olioon, joka sisältää sitä hallitsevan pelaajan
arvon ja pelinappuloiden määrän. Nämä tiedot ovat tallennettuna kokonaislukuina. Heksan hallitsijan tiedot:
0 jos heksa on vapaa ja 1-n merkitsee hallitsevaa pelaajaa, missä n on pelaajien lukumäärä.
Myös pelaajan heksassa olevien pelinappuloiden määrä on tallennettuna kokonaislukuina 1-16.

##Algoritmi
Algoritmina aion alustavasti käyttää Alpha-Beta karsintapuuta.

#Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet
##Mitä ongelmaa ratkaisen
Yritän ratkaista varminta tapaa voittaa Battle Sheep-pelissä. https://www.ultraboardgames.com/battle-sheep/game-rules.php
Aluksi vastapelaajia on 1, ja jos aika sallii lisään vastapelaajien määrää. Aluksi yksinkertaistan pelikentänluonnin
joksikin 32 heksaa sisältäväksi yhtenäiseksi pelikentäksi. Projektin edetessä saatan paneutua kentänluontiin tarkemmin. 

##Miksi kyseiset algoritmit
Valitsin Alpha-Beta karsintapuun, koska se on tietääkseni paras tapa valita eri siirtovaihtoehtojen välillä paras
tulos. Periaatteessa siirtoavaruus Battle Sheepin alkupelissä on paljon suurempi kuin esimerkiksi shakissa.
Aloitussijainnissa joka antaa kaikki mahdolliset vapaudet on 6*15 vapautta, eli pahimmassa mahdollisessa 
tilanteessa mahdollisten aloitussiirtojen määrä on 90. Saman pelaajan seuraavalla vuorolla vapauksia on pahimmassa
tapauksessa 84, jolloin syntyvä karsintapuu on erittäin lavea. Vastapelaajalla on jotakuinkin samat vapaudet. Onnena
onnettomuudessa on, että puun syvyys on matala, sillä kaikkien pelin mahdollisten siirojen lukumäärä on äärellinen.
Puiden syvyys voi olla enimmillään 15 kertaa pelaajien määrä, jolloin kaksinpelissä siirtojen lukumäärä voi olla
yhteensä 30. En ole silti varma onko näin matala, mutta lavea puu mallinnettavissa. Oletan, että puuta ei voi mallintaa,
ainakaan omalla koneellani kohtuullisessa ajassa, mutta tutkin asiaa vielä lisää kurssin aikana. Jos en pysty 
mallintamaan koko karsintapuuta, joudun keksimään kriteerit parhaille mahdollisille siirroille. Tavoitteena voisi
olla esimerkiksi pelaajan omien vapauksien maksimointi ja vastapelaajan vapauksien minimointi, mutta näiden 
kahden tavoitteen painoarvojen arvioiminen toisiinsa verrattuna on haastavaa.

#Mitä syötteitä ohjelma saa ja miten näitä käytetään
Ohjelma saa syötteinä aina senhetkisen pelikentän tilan. Ohjelma laskee kunkin mahdollisen heksan kohdalta lähtevien
siirtojen tulosvaihtoehdot ja valitsee niistä parhaan ja tekee siirron. Siirrossa pitää valita sekä määränpää heksa,
että kuinka monta pelinappulaa siirretään ja kuinka monta nappulaa jätetään lähtöheksaan. Näin ollen pitää arvottaa
paras mahdollinen kohde siirrolle ja sen lisäksi siirron "suuruusluokka".

#Tavoitteena olevat aika- ja tilavaativuudet
Tavoitteena on O(b^d) aikavaativuus missä b = haarojen määrä ja d syvyys. d tiedetään enimmillään 30 syväksi, leveys b 
on enimmillään 90, mutta suppenee epäsäännöllistä tahtia, joten lopullinen aikavaativuus on pienempi kuin O(90^30).
Tilavaativuuden tavoite on O(bd), jo aiemmin todettujen rajoituksien perusteella tilavaativuus kaksinpelissä on vähemmän
kuin O(90*30) eli käytännössä vakio.

#Lähteet
https://www.redblobgames.com/grids/hexagons/
https://www.ultraboardgames.com/battle-sheep/game-rules.php
http://www.cs.umd.edu/~hajiagha/474GT15/Lecture12122013.pdf
