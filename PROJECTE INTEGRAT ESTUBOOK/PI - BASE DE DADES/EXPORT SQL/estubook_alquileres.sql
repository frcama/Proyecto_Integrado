-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: estubook
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquileres` (
  `id_alquiler` int NOT NULL AUTO_INCREMENT,
  `Ubicacion` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `MetrosCuadrados` varchar(50) NOT NULL,
  `imagen` longblob,
  `fecha_anyadido` date DEFAULT NULL,
  `NumHabitaciones` int DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Ciudad` varchar(45) DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_alquiler`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquileres`
--

LOCK TABLES `alquileres` WRITE;
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
INSERT INTO `alquileres` VALUES (27,'Valencia','Carles',520.00,'123',NULL,'2024-11-03',5,NULL,NULL,NULL,NULL),(28,'Cerca de Universidades','piso',155.00,'70',_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	 \Z  \Z (\"%\Z!1!%)+...\Z383,7(-.+\n\n\n\r\Z-%%---/--------------------------------------------7-ÿÀ\0\0\á\0\á\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0L\0\0\0\0!1A\"Qa2q‘¡#B±ÁðRSbr\Ñ\ÒC‚’¢\Â\á$34“²ñ£\â%Dcstƒ³ÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\'\0\0\0\0\0\0\0\0!1AQa\"2¡Bq‘ÿ\Ú\0\0\0?\0¦&•5{Ç’#J•*@4Ò¥J“Ô©âšŠR¥J\rJž•\055=( §§¯,@hm%li7\ÐõI\Åø\ÉBm †±\é\ì}¦¯0øvº3z–ÿ\0H\î|¿\Ð¥D\âœ6\Ë„¶Rº(\"K\0\'P<º«\Î\çò\Óx\Ä\î\âñe >\Ú=Æ,\Ç_3S-ð²³F–\ëµòöU÷-r\ÝË¬R\Ú6±\'LÁO‰: >;˜\Ð6\Õ\Ì<;‡\áU0\í|v\Ù\æ\çf	[zDœ\ÇA-¬lhx\Û:*»ð˜ee\Ê\ça LxŸ!­O·qm€¨303>\Ä\ÇE\Øk©©6°wqE«,.€N\Ê /»ºƒ\Çmhÿ\0—}Û·ˆ‡oÕT~ñÝ¾C\ÛSN_‚­.€®\ËxŒY½\Ù\Õ\ÚB\Ú?\ì­†rf\Ê4Ž\Ö\éB3°\ÐHŽ\â\ì=¦O˜¢5\n€*€ª\0\0\0 6¦ž—D¶\ßfb\È\']\rB¾÷p\áÅ¿øW7¦†C¯>dmV\ÜKVõÔƒÝº\àyC\ÛÊ¸f\r\Ýmþÿ\0gðª\èLñf\èe¦AÚ½\Õ8£»F¶\É\ï\ròŸ]1œD¦ É›n-\0‘\å3^™Vq\Ï\Æj\ÙiJ¸ý!?M~\"•uü1ø\Ù8Ò§4¢¬\ÈjTô©\æ)W¨¦ ŠQOJ(\ÌR¯T©1\ÔñJ)\0Ô€§Šg\ZuI\Ê`Á 0`Á¥\'J\Çn„ªÅ‚\"\æsöv\Þ;Sp\Ü9Gy\Èv‰…Oiñò\ëó¯K\Å,Z·\0\Ð\Â)\ï<	$·‡\Ï\ÃÂ†ñ˜û¸£•T(\ÍW@\0\0‚\íóÖ¼n~~NI8ôW‡‹Ž	K²Ï‰ñ•WÐ–;¹\ÑDõPz\ë¿_:\ã\Ë\Øu7\Zþ2\á·l©9Î¬ú-®\æv˜;i\â8¥¤¶Dv\àP$Ž\ê\Äjªw‚7m<ºÕžƒb.£\âˆ&Ý°X¹:\Ò«Ž•„Rõÿ\0Mdï±±ü\Ó~òv858\\>²\ß\ÖÜ\É\'UŸ“Ôš¢\Å\à•0\åT}¹\'y1\ÔÔ·¼\ÊfŸTtý\ã°\é\â|«¾#pZ\è\Ñ\Ýt }ýw5ÑŽŒ­]¾„\ì\å\Âß&ÿ\0Ü‹2kC-@žŠ\ík‹´$…¼„f3¡¶\ßGB³lRr)5(¤0Ý…þ“\Ä#(!Áh HV\ë\ï¡>eÁ„\Ä\\U\0\0Á”\r€ 6Ÿ¥ñû‹gŠ[¸\Ä*µ±$\ì4tüó…\Ô{\áÑƒ‚HÄŽ¾QTƒX›=wGŒ°W\ÍzyyQ,MSX¼a\Þ\Z\ã\æ*\Z\Å\Ú\Zyi•=•*³ú\r¿?**ü‡\ÄE(¯QHŠú\Æ<\Å(¯T\ÑL¦¯QJ€<\Å*õM@\rJž‘#\ÄkµK©«†#mO\È{j‹‹t¿™[.‚F„4 \èk–~T\"\élê‹6­\è$5SÄ±ò“oQ›$\ë©#7tuÚ¸vw/¥¶Ï•`–-°† e\\\å\×\ÃÄ\êÇ‡Ø€-\ØFbO¬D±;h–½7&¹9ü¼\Ö(ß‡\ÆQÜˆ\ÃFf{¬@\è«\ë\ç\ì\ë:	>Cz¸\á<&ö ‹v-\Z\æ\Ä\è¾\Òd\Ô~!\ÂqIx\Ø\nÂ«;±(a \Ð\Ö5­g\Ñ\îZÀZLÙ ¼·Rs¶ÿ\0ur5{gM¥¤cø\Î{µ»i™mZ´\åõ²˜&Lið÷Ö©À\í§ô6D$ ±p|‹þ5\â\×\"[|E\Ëø—7\\gK ‹$[«„š$\Å%¤µ\Þ–’ X\"4\Û]ª¤O°—9ešÅ¸L„€Kº‘A7oVt®ôI\ÅxE¥°sC3Çˆ\ÑF\Ë\ì\Zž¤\ÕôŒ€•\Â[7HþµÁ	ý‘\ë7¾¶ƒø\Æ6ö!.6\"\á¸z\ê¨ðQ°ªjRV\ÉTž3”ð	j\åÂ’3¨‘$ƒ|=z\Ñ)¬\ÃÑ\æúJ¦f\Ê\Ö[»˜Æ™L\ÄùV5Qc0¦šôkÁ4„\0zMµß°\Þ*\ëð ÿ\0š„…\ÐFW÷\ÏZ;ô—nl\Ùaöný\å?\ËB\\O„5»Bá‚DŽµK`\Ê{–Êšª8B·³\rU§\ÜOCV([bI\0\éð¦ªD³—`)Wi¥N[-b”Wºjö\ìòO1M\î‘\ì\Õ\ìŠQE\â”W¢*-\Ëó¤¦@hœß»\Z\ë\â~u2šCŒ[:^¹\Z\0Y¿DDÇŽ¿C\Å]R§95ƒ#.†7\ZŸ?…r8€€¨r	\Z	˜NúøIŠŒ\ØSr\áÈº\è\';{AõG‡‘\ÛZóy¼«\Ò\è\í\á\à¦K\à\Üö0…°;¢K9\Ð’gA2|t¥q{6Ñ·lb\r\Æ@Á®lö\ËL\åw‚ÚFºF\Õ÷;²’ÄŸªy±\Ýý„‘5OÅ­Œ¨»c§\Ãð®NÕ®Ë¬v-Ú»\Ù\æç²’\0*\09£|°DLyV—\è\Ç\Ù\áYœ«^k™€\Z\0x\á\ç]1ü«ô‹xE7Z\ÒZ²²™»¨!I\Ñ}]Nÿ\0}_ð®k\rhZ²™PkI$\îI:’zšZH—l \Çò\Ò1wo]ºV\Ë\åú»r¡Ngû+ \èºùô¢lÝ¤\í¨D]”\r\ä\×BFÿ\0:ñ‡º®¡•ƒ)Ù”‚M\ßQJÀ\èMQóMõ|\æFº	!À#O¥g\\\×\Ç17¯]¶÷ˆ²·¤D\"XX\é\ÔÇ•p•Ð¬Á_ÿ\0\é5xR±\'nŒò\Ñ4üùšô÷ƒ-À?F¼ap,\å£\ÌO\Ëz%áœ—y\í±aÙ©S«H\Â$ü#Îº\'J;2‹ýZCz4v\Û\ZŒ¥\\|Q´øÖ³Y‡\'p‹\Öqxb\Ë*\Z)B¬³\ã¹§\\­\ßF\ÔxcLM=5HÁ¾·86?¢\È\Ä\îj¦Ç®~…µ=>\É\Ç\È\Ñ?4ZÍƒ¾¿ý2\ß\Ý!¿\Ë@ø5oè‡er\ådeŽô\Æ\çÎ©	‚“‰\ìò’%I \Æ\ãmÒ¦:™ƒ½B\â–\í\Â\îÇŽõdý!gõƒ\çJ‡;+Ÿ«oþ¨H\"š+\ÜRŠ÷$\ç¢ºE( dW7¸]|ÿ\0\n\ïQ|]½ˆlZf¹ $\ê™:‘\Ó_ec\Ï\Ëñ\Æ\Íx¡›£–7ºg Ä˜V04\Ü\Äg\î®Z\í\È(À¬b}X\Ðfð$\ëLkÖž\ç\06Ø«•»TeH-\Ô1C\'h\çD|ŸÁ/öî’‰hÀ\Ô6R€µ™$t\Ðu¯*|³™\èCŽ1)¸/geµa\rË‡Y n \0x\Ï]õŠ~‡g\ÄÚ¶\Ð\ßTm‰aœ·\Ù:\íF¾‹p—o\â;6Ë•\ç½\Þ$A;…\0yQ/ò¦\r­Ë£Su÷ž¹F\Ëó>u)F/{e\Û}hôƒ\Ãn\Þ\ÅÚµb\Ñ!lˆ\n\0\n6ž\n\"({‹òEðPgBÊ\å“Ô–€b64cÌ¼\éo\rr\å›6‹\Ý\r\ß\'º nF¬b?bù«ô]X» \ÊQ`wb\ZøšU*+$m©G@\0’`@Ž§a^p¸”¸¡\í¸t3§Cƒ:ƒð¬\ÇÒ¥öljY,\ÙÊ°·˜\å.^\æ¹zªºŽy6\ÉL… Ž\é0|Ù\ãK\Ób½™÷<ñ;\×1W­5\çm¾E´/I-±™\Ô\ÌtŠÐ¹)c‡¢ûš¸\Û\å,7mrû©¸÷¼7ª\'À\rýõ|ˆ\0€\0 \ÐSrMR[0œ‰h\Ý{·Ü¾kŒ\á@%‹\0N\ç~‘D8ž†\ÃYE„D\ÒDûÏ‰©á«Ž-Y‘Â¶V*r´L\Ð\Ç]zRrltW`x]Œ:Êª®Q«±<\ä\è=\ÑTk\Ò\r	µd¶&\éeµ\ê\ìws¤{&³n!Œ7\ØV\"\î%÷\ì‡uW\Ü!FþU#n\áRR\ÚÛ¶\0\Ü¤\ê\Ô\ÙI:\n9g¬Ý¿f\ßgqUD“\â§\ï§¿Â°L·ÿ\0\Äp\Æc\ëûÿ\0\n\ßf\Õ\ZÂ›\ÝOM4€·šÛ¯\é#ˆ\"±;B@\"AŠ\ÜÀÖ²w»v\ÚJ16WY#Êª\"eE\ÜHõ_CÐ\ÏÊ¼]¸½ŒŒ\È\Ú2AoC\áQÁ«\è‘\ä\Ó\Ô_§§ŸÀÒ¤TS\Å<S\Å{§yŠh®‘K- 97Æ«n½\åF#=”¾Fb²\rÐ¢2\æ\ß&£@`Îµw…³™\ÑI€ø(›œ8b¯+g	jÍ£=I2L ‰š\àó\âŽ\ßvú$Á«q·ˆµm¢\ÒÁDxwAùÖ\Ë<¼0½£/r\î®cA©0:\î\ÇS¿…Pz?\àƒ8›\ÍteYfr˜“1ò«\Ëü\Çm°w±8v\Ì-\ÈFe`¬\Â\0¡+,\é5Á—\Ñ\ÙE\ÝËT–!UD’L\0·@\0ûª†óeŒF!la\Ã\\Å®\Ä ¯w6®I :§á˜œF\'…\â™\Ë_»q™r¨\Ü\\ª£@¢Iƒ\àd\×^K\åk¶.ö÷™sd*\"cRF6½*H`1\ßÍŠÄ&o7\ß~]l\Æ\ÙQ¹\ÄZ\Ú]Ehü3ó\\{·\ßWrùWö‰:ž‡_:\ã‡\å+Ž™\×-õq®’®û«W8\ÒD(½‡XŽa±\ÖQ®”;(%@$\Â\ÎÚ“¨Ö¥\Õo\æ.N\"ú\'P¤\Ëb‰cð©|?·m¥Åœ®¡\ÖD\"DŽ†+”vñüþE5·v#P|Á\Ö\'\Í\Ø\ë×±’þ%\Ú\Ò\Ýp–Á\n¹C,fÓ©­_“”\r…”ö=i¸\êÀ\ãü÷k—-\Ø[V]“´=÷0JÈž\èÛ¨÷\Ñg£«÷7n½\×7^]\É$\í\ã\ÓÊ‚×“ñ·¯\Þ\"\Ú\ÛCu\Èw;‚\Æ]þF´NV\á?E°,—\ÎC3ˆ\Ô\Æ\ß\nn¨¯…º*Í¼?i{´l\Ì`.R©”Ô˜#`=ô°ø;\æ\Öw|¨\0@ru1>UoÊ˜[Ë‘\æt…\'p:\í\å½_\áùj\éL•D™3˜Áò\ZmûU²’HÉ¦\å£=\å\ë\n·ð·¥úJ«k¤¾ºVWs–™l¤[¾.:‘óD\ë¼oZ’1  ‘$xN±\çX6™µ1\éf¯4ªB†s\áYŠñ[8n%‰n*,¾§\Ï+~µ§X¿¤\ì>N ÷\"eU¢?`~\Ô\Ó‡\âv1‡{/™H\Ô\0„\r\ê¾ž\Õef\Ïo\ê\ÚdA\Û\Ù\áS08\Ö.?´¢g\ÛZ\"	Ý’Ò®½º~\×\ç\ÝJ˜yiˆ`¶­!l\î \ï:r©\å\Ü\0{\Ú¦¸&+²u¸¶\\²\'iMµP\0™\Ìr\É\ÓN¢&½yœhá‹\Èû8=f<\ãxñ‰§Š\ç\ÅqÊ·0w1\ì\Ã1K¶g€5Žðö¶Š|\áy\î`s]l£ÁI…Ó ÷\n\\^R\äuA\É\ã¸+,¸œØ‹^M?\0O\áTÞ‘ñ÷zÙ¸\æÕµ\0[‘–rI\Ö2~\Ô\Åòª½\ÜX\Ö\È ž„6\ëö£m\èw˜ùgyñ¡Un\\93		X®_&jSO\Õ>4b\Ó$r\ëðœR¤³Þ¹‘C4\Ôô\ß¼\Ñ\å\ì˜1†¿\r$³\ä,wƒD\èN€tÚ¢ò]ƒ\á\è1–û\Î\Ì\ÅÀ]XÆ§ö@¯<\ÍÎ‰‡µf\å«Fÿ\0n	¶Á²¬­#7Œwuƒ­r½ôtta0©mB[EE*ˆ/¾•¼B–\ÈsA0˜}Å‡\Äx×®PCˆ\ÂZ¿ˆU\ÏqseR\Ù`\ê$Ox€@×¨5Z\ÜK´\â8µXð¶m\Ûl\æ¸ú{2\ìRk\ìÀN!Ž\Æ\â	\íq=•©0˜yL\Ât\Ì\ÒX\È\é5AÈ¨\ç‰X\ÌµbT;D*±‚\']@üš\íoŠ)Êª¬Ç¬\r\ë$øÚ—£L1<J\ÓIõn·”\å#\î5«T‰L\é\ÎpüK3\\\ÌYh\n\ÛZ÷\nlYA\Ð\àr‰\Z\ëkŠ\ÌÊŠŒ³\0\'\Ì\îk ¬œ¬ª°ž°\â\íË·]\î3¹h\ÑTI˜\ê\Ñ\ï]‡²¨¡B¨\0\Ð\r·¯tñC“aGŠó~\Øe*@ ˆ ‰\Ú:\Ô%\Ìx;.\â-«\r\Ô\ÍýÔ–ùSð>5g\ZŒösmœ\ÊVLt:\Ä7•*\Þ/ˆY°³z\í»@i\ße_„Ÿº†8—¤\îoKf\åö\è-¬\ï<|¦²¬n;kš@,ÅŽžgS­:[\0h\0ö~?\n\ÑA\Â\×\ç\Ûaßµ\Ã\ÝC˜\ÎR\Z“®£_j¸Kù\í£€@dV\0uPu5óŸ»ùƒ_Dð\Ñõ6§õiÿ\0h¨’H{öv\"œRjT€U—úRÂƒ‰¶N\ÍgË£7ñ­@š	ô‹À\ïb\ZÁ²¤•ƒ	R?\î§\Ä\Ì\Ê\Þ\Ú\êwÝµûÿ\0:\×^\ÙF\ÐA:@Ÿ»Oˆ¢œ _\Þ\á¶<‰\'\æ§_O`«\\?£û ÷\ÝÜŸ—Ç©&|6\éZ\æ‘³>ú]¿\É_\æ¥Zû‡ý¯úŸ\éJ‘,¤N_Äµ¦E°ˆÌ¹s\Zfd.c·™÷\Ôs\ËH¤µ\Üe„•\Ê\ÝòtŒ•#m§Â½\Þ\à8§µ„bø‡{\ÑÚ©Í–Ú’ ž€Î¾ñ\ÌUû®,­û¬\Z÷gmM\Æ 	!dL¬Vi6]#§6\à,†¶–q)s*œ\Äe‰$@\Ðø\Ô\éGkµ¶A´2\n¾\íh£›p\Öm\â\î[¶¡¨€HœŠI>\Òf©…Ÿð\Û\çBn¬M+ýÞ»ˆ|IbI\î\Ì\'¼\Ù\É\'YõUtš\ç\éwŒ\\\ÃÝ³‡³yƒ7.\rtU<:\É\ï\rj\ËÑž90xN*\â³fc	!ub:=¦³ni\Ä]\Å\â.\â{7ú\ÖhÐÈºLB\0<4ªõ`» ¿›p\íw\r\ÃE\Äg¼m£RÁ\0Pe‡H¢`\å{¸…Â¢k\ÙZ\È\Ìd\ê\Ä(þ–ž\Ýh³g\"¢²Š¿\0|«£BŒ\Ì@©0>t²ô‚\Î?Ì—ð°ø{	ln3O«@˜’O]\ê#+\\L]\ÂA{®7$4“ž÷\Ü+·6ñ.—GÒœµ\Õ]-.s¡2$ \ë=H§N4‡†\â1KfÀ@\Ù	DDwˆ\×I=uR\Ó{e]*:ð\îQ±‡¶uwÊ†X\'M\ÎQ:Äj\'+p+Vñq)\n\Ã}5ušbx†\"ñ&þ\"\í\Ýu˜\å\Øý‘¿•úq—	w*¶L\Æ$²ô\'xœ“û×£O\â<{	cK¸‹Hß¢Xþ\è“ò«%E`°t\È\ëŽX\ÇRó\'\Ý[\Ó\èt)\Ê\Ñ1•™^3\Ò:\çü$³eL\å0]£\Æ[OðÖ“Án³a\ì3™ciT}õ’ð®NÇº\ÛR	¸ÈºÀóŸ•k\Ü>Á·j\ÚJ\"© \Þ)\Ï•»Ù†c·L\rqg\Ï\ëMhþ‰\Èú=\ßÿ\0)¶ýÔ®¶ý`ó³\Ü7nfr@–b\Úe\é\'ÆˆøO\rµ‡P–m„\\\Ò@N‚L’f\0¢sN4F˜F*\Û=û\á˜ºÓ·S¥w\ÂpMÁ¢Æ¹}óc¨¢¾RU·w.•C\Ú/¬@\Ü¦®09ˆ[7]†[nD\Ì5\Ë\Zƒ\ãVª¶D¥+teøŒu¼\áˆ(4Ž½\Ùö\Ö\é\Ë\×3a0\Í36-ŸotVQ{„]²n£\Û~ò\Û|§x\'Æ´¾Jqô2õKJŒFP$k¾¾”}—qMùüü)™ö×“s¦¿˜EŒô?:ò\çóùö\Ó+~}õ\åO\ç\å@\nù~3ñ¤Sóù÷|)4ž±ñü\ïH¯d?c\åJ¼öcö~T©G\Æ9’Õ«—,v¸¶\Z\é\Ø.P¤ÁiLF\ÇqA<7‹[\Åcð–\Ó	n\ÐH\ÊA#(\Í$\ä£ý\èÓ™8E—KŒM»7.l\ßhœºJ\êD\ÈX‰ þU\á\Ö\ìc1Vò\Ý0\ï o¡	óõA_E7ºn_¼\ã­\Ö#\Ù:|¢¡!¯+1¹óÖ’¶ž\Ê5BVh8w±c„Z8…vK—sB%™Ø¨2D\èø\n¨Às=¶¿nÍ¼#[Gt@;I=\æ, û\à\ì*÷˜¬vx,Œ TNŸWi˜“ ˜\ÌG¾(K”0Ý§²N\ËpN¿V¹¾ñZ(¦¶C“½\\g\ãˆ}\ÝÕ·k´Q!x1 ³\È\Úv\ÞGZ¤\æ\\¿\ÅY5ÁÛ Ù˜ªú²°v~hþ\Ç-Z\\Q\Åfcp¶h\Ó(•\Èt~û\Ô\ë|*À¸ovK\Ú1’\äI˜s±€¸RRŠ­M£9\çœËœB\æ[lý\Ëar©0\"cA\âOÆ­¸½¶±ÁnH$\ìA®ƒ–=’hôUG3ð¥\Ù\ì\ä\ÊÅ€“\Ý!´öšNv’Ù‡2°V$Gt\î|tÚ½Y‹Ø¯j\Øø³ÿ\0\n·\â|“bÝ–9\î10²r\Ä5?µ;¸\"\á÷Wf\Îg1~ñ¢S]L»Àò\Î\Ôd\ÃÛ‘± ±ö\ËNµj\rs.iI¨l(öM)ª\ì_\Ã[\Ö\æ\"\Êhw¸½7\ëÒ§\Zy\íKc°®xˆ*\Â&A#AøI8,¨/\Ü*Hl¶¶#¤±‘½^r\ß»mpY¹hÉ–\à\0‘5Š)Š\ÉxK(£¸ˆ¾À\Ý\ï©X\ë©ð\ß\Ýü}Õ‹ñ\Þ9¼E…\Æ]\Ò\ã*\åÊ¦BT \Ò~éª»vñ7Y•¯b.\ÐÜº\Ço	\éWû%\Í#W\ã$v¤û+±m\Ó\ÌU·Oªó’}\çJ\ÄÓ…[ªSnX\É7zNû\íð­;\Ñ(\'‡¦bI\í^I$\Ï{/_!P\áE©Þ‚LN2Í°MË¶je\î\"\è N¤mª±<\ßÃ’sclNŠÙ¿k\ì\Ï\çJ\ÉG±™\Ë),.>“´1\ÓJ’œ6À\ZZ\Ú	ûþúµÆ‰É‡x\ÏI\Ü9&óþ\í¢7ýò»~fŒAC¯Æ±‘‡Q1iG±Gð­ƒ…\Þ\Ïf\ÓH\ï[S\ï\Ê(”h;M”ŠöG\çóÒ¼/\Ïñ¨(]\ï?€§¯:\Ó\Ó\0\r8Ã‘m\ÚÛµ\Ç{\Ì\ÙtN¢O\Ö\Üiò5G\Â\\Œ\Ä\ï]\Ö\'@[4#û5ßŽs\Î.\ÞUQeKa\Õ\î}[f KÈ…+¼\êMF\Æ^a\ÂðŠc5Û­p\ÇP%G_\rSn¨U»\r|jF\Z\ÑvT»*\í¿q¸¤xkW™k>;\"{ù–P[ü´˜._‹p»W]^\á!m«…€\ÙsI>Jþ>\Ú\åNeq=­²g+\Ì\×OvõQ\ÏV\í¾&\ãº\ì‘THB\ç\ë¦\í\Ôt\Ð\î\'\Ó1\Zwm˜ý\ç;~\èÒ©¦—bF¥ciØ¢\\Gaº«©#\Ú‘®š\ÔN\Ì[÷M«WU\î\0Ä€@¤)2Dz\Ìýh_Ñ°E·z\â RAú²\è\ìd	3\Ó\ÏÎ«}p«\Év\íÛ¶™>¨(,’ZLOî•&ƒa^;œ,Û¾p\Ù.=ÀÊ‡(\\ ¶SÕ¤À`N•\Ç\Ò¿†µm\ì2k…IdÍ¤ O­>\ê~	Œn+Ú›L,œVlñö\Õ\'Û”{Iô³wL:k©vù(Û©Þ…V†€\î#\Ìø÷¶\ÌØ¶\ÒU·iD\Ì…’\"}ôQ\èûbŽ½v\ä›`\ä9T‹lÓ¢Ž¥HöP\Âr\é©.»ÿ\0h\ê}\Ý6­p&\ï\rÅ Ê¯z\åÄ“$\â(>;UI*ò o–x\Þ6ö3\n.b\ï¾k‚W0\ncy\n ‚³¡­c˜˜Œ. Ž–\\ÿ\0€Ð—/ò\Ë\ì]k¶\Ïb\Ó\Ý\r\ßÐsm½cð½¥«–\æ£$Ž™ð¨“E\Î‚X\ìÁ	n2\êJ’A=.¡\ïûj­¶\É¾\êOGÉ¦lUòoøsñ*Ly\n3Ew\áD¤™)QŒ`\ïŒ\åFfƒ\íc\â@\ÖN½\Ô}\È$vWzýgÞ£\È}\Þú\ê9\Õ.°n´h˜ùU¿	\áp\ê\Ëf\Ø@\ÆH™;u\' ¦äš ­™¯\ÅÛ³Æµ\×TVb1\0›Môš›„\ã8{wq¯,=À\Ê\Û\ÏtDN’7©œ†X¹‹\Çö¶‘\Ê\ßK($\Zbv÷U\Æ…\á\Å\Û\ê,Ú€\È}E\êƒM¼Dû\ê\×F3JÙšñ,m¿¤\r\Üb\ÐÀ2\Ç\åGþ‰\Ø}Dƒ®õý©üh‰XQ\Än¬\È¶ˆtø\Ñ?£ ¬H1W>\äÿ\0Z™\Z£?\Çý&\Ý\ë\ê˜K\×>¹\á\Â<f:wuö\ÍuÁ\àø“´\Ð:\Èað•l7\ßÎš\'Y\ÔRÍŽŒ˜ò\ïe1fõ\Ê4ó›“ò­#—\ì\\·†²—`\\T\n\ÛFž\É\é\çV3Ö\Zió¤\ä\Ø$x#óü?…x?Ÿü\n\èEsaÒ¤cþwjjóÂž˜?9a0l÷oŒrµö¸Z\î÷bÎ³ Os\çh¶p¸\Ô\áP{ÎŸ\äªÀ\\{ö-¸ƒ~ú\Ï^ ´øFcVÞq9±\0\î\Î\Ûi©LjšŠ	a\è¿›[õvXû\ÉUû‰ {M$\éi\È|@\á­bq9C\ën\ÐYNv0`\Ä\ïŠO±\'z\'s~Íˆa‡|¬\Ìô‚4}@\ëWˆ¸cY\Â\Ý\í«5ÝŽðh_ŒóõÛŽm”A¼À‘\×P\Ð\Å\áù½ð¸{\rv\Ø~\Ö\ßm Á˜…G€\ßC“¡Ñ O‰§ …ô‹oõ\rî¸¤|…X76ÿ\0ºœP³\Ü“.s˜?b#\ßÒ¤x°ž‚yÿ\0€b1W-vJHE \ê I þ”\0\éN¾R$\Ø;Nÿ\0´Tži\æK˜eX¶V\åÁ™;\È\Ê\0+9¥&`øÐ¥[X\å<]¥\\\Ö\å³\È– ø\É¡ú?Á5¬W\\§µsí“§ÊñüÕ‰¸C3,²\åJ½\à¼ö–\ìªÝ¶\Å\å‰*À\rIˆ\Ó\Â(|—¦7\Æû4\ni41\Ãy\Î\Ýû‹nÝ–,\Ó:ô~B¤qNmµ‡¹\Ù]µp6P\Úd\"®a\áS¡b\ÂÒšhXó\îô.ÿ\0\é=zó†ýþõ¯\æ§hx°ž)ò\Ð\Âs\Î\ZuK€xýYûš¬p<ÁjôöV\î¼ošNÛ¿¶˜©p\Ü\â]¿y.[óa• #C \æº\Û\áX€\Î\Â\í©hž\ãô>ß…óO6^±x[¶/	Ye{v‰¤\èj¬ó\î\'Áÿ\0\éO\Ü)\æÅ‚}–|\ËÁï‹‰t=¬\ì$)\Z±»y\n³\äŒ5\Ëbú°^ûö’©HŽš,û\Í\ãy®ý\ÈÎÝ˜ú–\ï\Ó]ªß“¹©\\Øª\å\\³m„™3°ð©É±\â’4öSe#o…RŽfÁþ»ü?–Ÿý§\Â~´Ÿÿ\0]\ß\å EÁ#\ÙJ}†©ÿ\0\Ú|/\ëþ•\ß\å¯Vù‹}Vc\ì³xý\Ë@ª4¯-ùùª\Ë\ÜÅ†X\Íq–vÌ—Þµ\áy›\Ö\éþ\í\Ï\ä¦\Ë]?1JªÚœ\ëûü”¨3,~j½\ÚÛ½}n—µ\ê\çUƒ®\Úë¯º©¸ž,\ßs{<gx‚±\Þ:dÀ’}•eÇ±+{¸›ˆ\Óvû¨ð6\'\í)\ë¤UM«™€®@L\ë\æ`Oþ+hñ}˜Ë‘V [K1dFž\Zhÿ\0ðtÁ\áÍ»…ûLA¸\Ä\Æ\ël$i\Ðó Ln>\àˆf\ÛIüþb¬ð\\]¯w]Ý•H*	]Àc\á3\ì¥>\Z½ŽWt\ã±\'9U˜\Ôõ>\ê<ôpYe¶nÕ«@ O¿J\Z<\âcp\à£C\ß@T‚HeCF\ês	\é\ì«JN\×q7£“\ÚI\ÑW,À&¥Ç¤Z}²Ÿ	u²!\È ‰¦òN”s|¼5\ï\Þ-û‡ýhE\ÄU•`uV¤xQW\ãxvÀ\à\ìZ¼­Û–\Ý\ÒG]5‚N¢¡\Å\ì¨\ÉhrÎ‹¯­¦6þ4U\éA¾º\Ò\éÝ¶c\Þ\Ýº*›‡f¹d\ÊÂ²–$¨\Ê$t&b¶¥s\æ1.\ß7-œ\è¨0\×PX‘\ãÖ¡Å¤Z–Á+ø€‹.\"\Zk¿¸W”\Ä\0¨$6\Ý6Ÿð¨œj\ä\Ûë«Á+\×0¶=	üüi`¨#þƒGL~œ’¤w_xý\àk¿¤{¿\ïm?elz‰ük§£ˆ8¯1mÿ\0\Ëþ¿\Z\ã\é\rÁÆ·—f=\áfj„¦Û°cµcÚ­ü)+\Î\Õ1\ÖYùkU|Ou\í°[W–û(\Ç\í\áK\ãlk—»&¥z(¶Cb\änmÇƒufü…b|\Ø{¹Jõ¶\Ð~U¡ú\'°\ëw™Cvq*\Âu¹´}ÕªƒŽŒ\å;vGôŠ?\ßh{%Žº\ËU\0k jdüý»¦®ý&k‰m©\æÿ\0g¯®’ñû\Í\íiñûýW]\çF`Bé®“#Â¼¥÷ez2:üho¿e\ßVsR6\àŸ¬#}I?Ÿ*\Òÿ\0eúb.\Øld\ïòóŠ{„Æ–\Ô\é3—\Î6	c\ÛT\Ø&s\'h\Ç+Ÿhˆû\ê\àb—R­=I½{\ê[_Aü”üV\ã„+²k Â˜\Ó\Îhû\Ñ÷6±*\ìIbN…H\ë\æ´6³>C=L{<|(\ßÑ¯fðH\ÕT˜ò\'ùªK=úP²{;\à\ì\']$þZ\Î\Ë\\ñ‹V£\é&\Ô\áTþ\Õù†ˆø\ÖGôµ+cIv6ôJ\ÏsÅ¾&•Dþ—¢ÿ\0þ©\Ñ9<GŠbÂ‹bD÷^\Ú\\]Ž€\ZZ4?u\â3;©Ù€\Ø¡\íŠW—,‹¿HWv¸x¸À«7\íeYøUP\å{\à=ö$±\Éu`É?\Z\èSh\É\Æ\È|*\í²@va•†c°#¨•\Ö|\ã­^ñVP\Ûbg¡:´‚À°\"z\ë,ù7–ð·YS%­}e\Û$‰\ï1\n.\ß`BˆÑ„\Ñbr\'\r[-~\í‹Å‚d·r\é*=n\ÎÚ†\×,\åÊ¯)2-è³¶¿q\ï=Ïª·\Ý`r5˜\ÙV=bua\áE\Ü\çŒl\ìB\"Ê¡QÊ‰˜(’5€\ÆbuŠ‘\Ëü+…²¶l)D@,I–%‰%µ&O\Ý\\y¿.a.(\n\Äep®`1Fž€\Ä{\è–Õ„+$ŸF>}+c‚+a™Dl’\Þd\0fû\Ô\'ô‰}.Z\Â0\'P\Ø`F»žóT<G„bË³œ3j\Ä\ÂC\ì\ÊImT¶\ä\ën\àò\ÊG\È\ëYÛ£F•—ü{1*ŸQj\ÖY\Ù\Î\Ø,W¨xEœÒ‹*&X\"\ÈÃ©òLH¨öp8…×³`BTH>D\ÍJ½€vÕž\Â²C\\UÍ–+>³Ký\êþK¨j¦\Ìc\Õ&7\é>1­F³r\Ðlid œ\'X “\ã\ZDÖƒþ\Ëà¾f\å\Åew¶¬r»K&€=¾5ZH\Ò3QM¶pôH€\ã€$Xm¿yp\ç¬u–\Å\Þ*s€VH$*¡bF¬d\n}§¥,\è\âùÂ»vh \ÎË± \0Ið¡\Ë\\¹‰¼b–¢!c¨\êHY\Ô\Ï\Ä\Öññe\Zµ³ž^T%x²ñûù»·\n	\Ð(óQ?:g\ælJ¶˜‹½>\Ù\"w˜27©\Ø~MbI»\rgÐ\çJ\ïþÀ¹ÿ\0\æ¬|.\n\×\ã\æô™—\Ë\Ã\í“x=e b\Ð]µ!K\0\Ô£/­Ñ‡;£Ø·cc>‹y‚µ\Æ\\ýža*H‘\Ý:\êvÒ³ó\È÷`\Äa\ÝsA!œDoöN¢\r:\Ú\à÷ð—´P™”\Æ\Ä8+Í¦ž<¸»%><\ã‹\í\ÑA\ÆW³\"\Ý\ÌSA½‹z\rt)?:n˜j\án G¬?d\ë\Þ¢cm&£a¸S2\Çbc¾\Ë) Ô¬:ÝµÀ\í2}Ä®Ÿ\nÁqM¬Ž‰MFX¾\Ñ_b\Ë^÷\ÚÇˆ¥vÙ† žµkŽ\Ã\Ã-\ÂX\É\Ê:\Îú¿}U\â7o}c$\×f¨ñi»‰û\ÍùùW°O˜ükžs$LC\ÏÉª@´\Û G2<¾Ta\è’ôcu°\í¤0\ÈB]‹øƒV|±Å›	·…=\Æ@h\Ú´6öH¢¬vj¼ñk6\n\ìn¥Li|+½\Ãn\æ2™D˜.È£üdQf/‰ñX$\ÊÛ‰\Ê\ä\Û_r!\Ì¶Æ©›m	½x£7«j\Ê\"±Ÿ\ì~´\ã\Çù¹WE7ôk~•¯úö¿šž­;kß£‹ÿ\0©ÿ\0¶•_Æ¾\Èù\Ö8Ð˜\"=óøU†‹$ú\Þý~t–\'@g\à*X\á/öDŸ\î¿\â©(\\#Œ=œEË¡»\Íp–ó\0\Ï\È\Ål|vˆ0$ô&±\Å\å\ëŒKw—û#ðoÂ»\Û\Åc°\ã½l\\Q\×,=«=óMJ„Õšÿ\03s²`m£ºµ\Æsl˜õ‰>\0|È«<W\Ã\âpixbU\èH:AmÁ\Ð\Ö\Äx¿\Ó2H*m+$®S§÷zùW1\Ç\0°l”;L\ë wd\0@¦§›¶_\Ö\ØMÄ“ð5Šp\Ì\ë\'‡Ç´Rh1q‹\Ð þÈš\â¦\ßB+mo N.É\à“\à*‹bmŽÍ¬\Ý\ZH0¬ƒÀ\Ìt´ª\ËX\ÄC¼ùEp“}\Ô6hD”Ç‰d\í\ì§a@­\Þ)q´$yh4ø\n,\Æó5\Ò\ëØ¨P¨£¿\Þ\ÒPu\0i©>-WVù?‹S\íwþ5Q\n˜lK\æ#¨(50\0\ËYé¿³Îœd\ã´Š—glO©t)Y]@&cÀøÏp}å‡¹¿…Qá¸µ.¯š&DAø\Ôû<J\É\Ú\ì{Tþ\×d|†\×g¸}\íq»\0÷Yw\í\åR—Œ\Û?\Ö/Æ¢m¶¹i½¤|]£\Ô\ë–\Û{\n­W$¿Rã»-¸h·˜\Ö\ì‡ \r 1\Øh6ö\Õ\ç\å¬kYtµo¶Îºe\0\ê7\ÎDVa†\áÏ‹»qŽ¡Lk°\0÷\Õ÷\âØŒ(ú)º\è=kL§T>:F„3Ö±~FWWŽ\à\Ô\î\Ú\Ù\Â÷	\Æa\Ë[¿aÐbT\ëý’zu¨Ñ¬NfC>q\\xö2û±g\Ä\Ürz˜\0ºU:³ÜšÉ¸¨\à\Ñ\ÐÜ§\'=l!L‰\ÕT\r†q$ø³¿\á]-ðkúö—\Ø:\ÄI\×\Û\ç\\8R\Ì-ö—…\ÌN›\ÎÚžš\rt\ÜUW\â¯u³]r\ìvðÀ\r€¬d“\Ùq´]¦hkr\ãk:@ÿ\0)ññ®wñ\ØP;–®–\èY\Ì{À\ßÙ¥S\á.¡ \\Ì“Ô+½\ë\nŽ\Ð‚A ùwA\Ôü)P\ì\íô¼ \\p2’Ee\Ì\ë\ëdù\ì+–	..+§iÐ›Š4“5	\È\"\'\ã^,‚Ou a\r¼n0^¾_[l|Ÿ…E8{®ÙœO\Ú­ÿ\0=W\Ì)c•J‘.,ºú5\Ï\Ö\ê[þzUOô\ã\áò¥E¡`Há›m\Ú\ÜR¥PjN±\×\Ù].R¥@€\ìOü\Å\ïþÑ¡\ëûšT¨•{JT¨]\Ü{*Jz´©SW\å_ùTö\Z¦ôƒµŸiû©R£\Ð\Í\ïX×‘OJ’¬U\æ§º•*×ˆÇº\äO\ëÿ\0|\ÝQ9£þi{ð¥J¥~\â¥û‚§‰U_ZTª¥Ø J½\ë/²¢Xÿ\0‹J•f\Ë&\ã?\á½soQ}‚•*@F4Âš•\0K·^\îÒ¥LT©R ÿ\Ù','2024-05-31',3,'piso  ideal para estudiantes de universidad','Valencia','alex@gmail.com',4);
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-31 21:13:31
