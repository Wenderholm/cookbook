DANE DO MYSQL:

TWORZENIE TABELI:

CREATE DATABASE cookbook DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

CREATE TABLE cookbook.recipe (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL UNIQUE,
  preptime INT NOT NULL,
  ingredients VARCHAR(200) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  PRIMARY KEY (id));
  
  UZUPELNIENIE TABELI W PRZYKLADOWE DANE:
  
  INSERT INTO
	recipe (title, preptime, ingredients, description)
VALUES
	('Jajecznica', 15, 'jajka, masło, szczypiorek, sól, pieprz',
    'Rozbij jajka do miseczki, a następnie lekko roztrzep widelcem, dodaj pieprz i sól. Pokrój drobno szczypiorek.
    W międzyczasie rozgrzej patelnię, a na niej masło. Wlej jajka i chwilę energicznie mieszaj. Gdy jajka się częściowo zetną, dorzuć szczypiorek,
    Mieszaj jeszcze przez chwilę do osiągnięcia oczekiwanej konsystencji. Po wyłożeniu jajecznicy na talerz możesz dodać jeszcze trochę szczypiorku.'),
    ('Rosół', 240, '1kg skrzydełek z kurczaka, 2 marchewki, por, kawałek selera, 2 korzenie pietruszki, ziele angielskie, liść laurowy',
    'Obierz wszystkie warzywa i pokrój je na kilka części. Jeżeli lubisz rosół nieco słodszy i marchewkę na talerzu, możesz dodać więcej marchwii.
    Opłucz mięso i wrzuć z warzywami do dużego garnka. Zalej całość zimną wodą, aby zakryła ona wsyztskie składniki. 
    Dorzuć kilka ziaren ziela angielskiego i trzy liście laurowe. Zagotuj, a następnie zmniejsz płomień do minimum i gotuj tak przez 3-6 godzin.
    Na koniec wyciągnij mięso i warzywa. Bulion możesz przecedzić przez sitko. Całość dopraw solą i pieprzem.'
    );
