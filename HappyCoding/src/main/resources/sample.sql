CREATE TABLE  users (
  person_id int(10) unsigned NOT NULL auto_increment,
  full_name varchar(45) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  USING BTREE (person_id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;