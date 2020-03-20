####Maanantai 16.3
Aloitin heksakon ja hashmapin suunnittelun. Tulin siihen tulokseen että algoritmien suunnittelun kannalta oli tehdä
heksakko kolmen koordinaatin taulukkona (x, y, z). Idea löytyi https://www.redblobgames.com/grids/hexagons/ artikkelista
Sivusto on osoittautunut korvaamattoman hyväksi resurssiksi heksojen ymmärtämisen suhteen. Nyt kun heksojen perusrakenne
on selvä tarvitsee minun suunnitella helppo ja nopea avain hajautuskarttaa varten. Löysin hyvänoloisen hajautuslaskun
https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function mutta aloitan ensitöikseni kaavalla:
x * (n + 1)^2 + y * (n + 1) + z Projektin edetessä palaan hajautusfunktioon takaisin ja selvitän mikä on tehokkain
ratkaisu. Nyt yritän saada rungon toimimaan.

Parin tunnin pohdinnan jälkeen tulin siihen lopputulokseen että kuoppaan hajautustaulun ja siirryn verkkototetutukseen.
Kaikki operaatiot heksakossa tehdään  kuitenkin säteittäin, ja verkon läpikäynti vie yhtä paljon aikaa kuin kunkin
heksan sijainnin laskeminen ja hakeminen hajautustaulukosta. Lopputulos on  kuitenkin lineaarisessa ajassa tapahtuva
toteutus.

Käytin vielä pari tuntia IDEn kanssa taisteluun. Jostain syystä IDE ei tunnista yhtään riippuvuuksia.

####Tiistai 17.3
Vieläkin pari tuntia IDEn kanssa taistelua. Jokin on gradlen perusasetuksissa ristiriidassa IDEn kanssa
Päädyin aloittamaan koko projektin alusta. Korvaan nyt vanhan projektin uudella.

Pitkällisen pohdinnan jälkeen päätin vaihtaa takaisin hajautuskarttaan. Määränpäätiilen laskeminen on helpompaa niin
ja on paljon yksinkertaisempaa välttää turhia rekursiviisia funktioita. Suurimman osan laskuista voi hajautustaulun
avulla tehdä helposti iteratiivisesti. Päätin avaimeksi a*257+b. Koska a ja b eivät koskaan ylitä arvoa 32 näinkin
pienen kertoimen käyttäminen lienee mahdollista ja säästää hiukan laskentatehoa, kun kyseessä on kuitenkin todella isoja
määriä laskutoimituksia. Harkitsin pienemmänkin alkuluvun valitsemista, mutta 257 antaa ainakin kasvuvaraa ja
tilaa virheille. Satun myös pitämään numerosta, ja ohjelman kehittyessä tulen varmasti vaihtamaan sen muutenkin.
Nyt tärkeintä on päästä itse ohjelmoinnin pariin.

####Keskiviikko 18.3
Loin Heksa, HeksKartta ja HeksaLaskuri. Monen tunnin taistelu gitin kanssa. En ollut oikeaoppisesti haarauttanut repoa
ja seurauksena oli sananmukaisesti päätön haara. Ongelman korjaamiseen meni monta tuntia. Toivottavasti tästä eteenpäin
ohjelmointiympäristöongelmat ovat takanapäin. Sain kuitenkin Heksan ja Heksikon rakennettua. Seuraavaksi perus
testiympäristön pystyttäminen ja yksikkötestien käyttöönotto niin että voin luottaa luokkien toimivuuteen.

####Torstai 19.3
Pieni korjaus päiväkirjaan ja kartanluontiin.

####Perjantai 20.3
