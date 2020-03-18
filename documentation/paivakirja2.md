####Maanantai 17.3
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

