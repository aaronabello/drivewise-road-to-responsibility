package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import package02.Badge_None;
import package02.Badge_SafetyFirst;
import package02.Badge_SignReader;
import package02.IntegrityBadge;

public class Story
{
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
		
	public Story(Game g, UI userInterface, VisibilityManager vManager) 
	{
		game = g;
		ui = userInterface;
		vm = vManager;
	}
	
	public void defaultSetup() 
	{
		ui.xpNumberLabel.setText("" + player.xp);
		
		player.badge = new Badge_None();
		ui.badgeNameLabel.setText(player.badge.name);
	}
	
	public void selectPosition(String nextOption) 
	{
		switch(nextOption) 
		{
		case "magpatuloy":
			next1();
			break;
			
		case "chapter1":
			chapter1();
			break;
			
		case "chapter1.1":
			chapter1_1();
			break;
			
		case "correct1_1":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_2();
			break;
			
		case "wrong1_1":
			chapter1_2();
			break;
			
		case "correct1_2":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_3();
			break;
			
		case "wrong1_2":
			chapter1_3();
			break;
			
		case "correct1_3":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_4();
			break;
			
		case "wrong1_3":
			chapter1_4();
			break;
			
		case "correct1_4":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_5();
			break;
			
		case "wrong1_4":
			chapter1_5();
			break;
			
		case "correct1_5":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_6();
			break;
			
		case "wrong1_5":
			chapter1_6();
			break;
			
		case "correct1_6":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_7();
			break;
			
		case "wrong1_6":
			chapter1_7();
			break;
			
		case "correct1_7":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_8();
			break;
			
		case "wrong1_7":
			chapter1_8();
			break;
			
		case "correct1_8":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_9();
			break;
			
		case "wrong1_8":
			chapter1_9();
			break;
			
		case "correct1_9":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_10();
			break;
			
		case "wrong1_9":
			chapter1_10();
			break;
			
		case "correct1_10":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter1_result();
			break;
			
		case "wrong1_10":
			chapter1_result();
			break;
			
		case "chapter2":
			chapter2();
			break;
			
		case "chapter2.1":
			chapter2_1();
			break;
			
		case "correct2_1":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_2();
			break;
			
		case "wrong2_1":
			chapter2_2();
			break;
			
		case "correct2_2":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_3();
			break;
			
		case "wrong2_2":
			chapter2_3();
			break;
			
		case "correct2_3":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_4();
			break;
			
		case "wrong2_3":
			chapter2_4();
			break;
			
		case "correct2_4":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_5();
			break;
			
		case "wrong2_4":
			chapter2_5();
			break;
			
		case "correct2_5":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_6();
			break;
			
		case "wrong2_5":
			chapter2_6();
			break;
			
		case "correct2_6":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_7();
			break;
			
		case "wrong2_6":
			chapter2_7();
			break;
			
		case "correct2_7":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_8();
			break;
			
		case "wrong2_7":
			chapter2_8();
			break;
			
		case "correct2_8":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_9();
			break;
			
		case "wrong2_8":
			chapter2_9();
			break;
			
		case "correct2_9":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_10();
			break;
			
		case "wrong2_9":
			chapter2_10();
			break;
			
		case "correct2_10":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter2_result();
			break;
			
		case "wrong2_10":
			chapter2_result();
			break;
			
		case "chapter3":
			chapter3();
			break;
			
		case "chapter3.1":
			chapter3_1();
			break;
			
		case "correct3_1":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_2();
			break;
			
		case "wrong3_1":
			chapter3_2();
			break;
			
		case "correct3_2":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_3();
			break;
			
		case "wrong3_2":
			chapter3_3();
			break;
			
		case "correct3_3":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_4();
			break;
			
		case "wrong3_3":
			chapter3_4();
			break;
			
		case "correct3_4":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_5();
			break;
			
		case "wrong3_4":
			chapter3_5();
			break;
			
		case "correct3_5":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_6();
			break;
			
		case "wrong3_5":
			chapter3_6();
			break;
			
		case "correct3_6":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_7();
			break;
			
		case "wrong3_6":
			chapter3_7();
			break;
			
		case "correct3_7":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_8();
			break;
			
		case "wrong3_7":
			chapter3_8();
			break;
			
		case "correct3_8":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_9();
			break;
			
		case "wrong3_8":
			chapter3_9();
			break;
			
		case "correct3_9":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_10();
			break;
			
		case "wrong3_9":
			chapter3_10();
			break;
			
		case "correct3_10":
			player.xp += 2;
			ui.xpNumberLabel.setText("" + player.xp);
			chapter3_result();
			break;
			
		case "wrong3_10":
			chapter3_result();
			break;

		case "final":
			finalPage();
			break;
			
		case "back":
			ui.frame.dispose();
			new Game();
			break;
			
		case "quitGame":
			ui.frame.dispose();
			new Game();
			break;
		}
	}
	
	public void instruction() 
	{
		ui.mainTextArea.setText("Drivewise: Road to Responsibility is a Filipino text-based "
				+ "adventure game where you are a student-driver aiming to become a responsible"
				+ " transport professional. As you journey through realistic driving scenarios "
				+ "in Metro Manila, you’ll face challenges involving traffic signs, vehicle safety,"
				+ " passenger care, and ethical decisions. Choose wisely in each situation "
				+ "to earn Experience Points (XP) and unlock special Badges like "
				+ "“Sign Reader” or “Integrity Badge.” The more informed and responsible "
				+ "your choices, the higher your XP—and your chances of passing the final "
				+ "road simulation. Ready to take the wheel? Let’s drive smart.");
		ui.choice1.setText("BACK");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "back";
	}
	
	public void Menu() 
	{
		ui.mainTextArea.setText("\"Sa lungsod kung saan araw-araw ay laban sa trapiko, "
				+ "isa kang kabataang may simpleng pangarap — makapagmaneho ng ligtas, "
				+ "may disiplina, at may dangal.\"");
		ui.choice1.setText("Magpatuloy");
		ui.choice2.setText("QUIT GAME");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "magpatuloy";
		game.nextOption2 = "quitGame";
	}
	
	public void next1() 
	{
		ui.mainTextArea.setText("Ikaw ay isang 19 taong gulang na estudyante sa kolehiyo, "
				+ "pinili mong maging kalahok sa isang bagong programa ng LTO na tinatawag "
				+ "na \"Project T.S.K.\" (Traffic, Safety, Kaayusan).\r\n"
				+ "Ito ay isang virtual na training simulation para ihanda ang mga "
				+ "kabataan sa responsableng pagmamaneho.");
		ui.choice1.setText("Magpatuloy");
		ui.choice2.setText("QUIT GAME");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "chapter1";
		game.nextOption2 = "quitGame";
	}
	
	public void chapter1() 
	{
		ui.mainTextArea.setText("Kabanata 1: Kilalanin ang mga Senyas");
		ui.choice1.setText("Magpatuloy");
		ui.choice2.setText("QUIT GAME");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "chapter1.1";
		game.nextOption2 = "quitGame";
	}
	
	public void chapter1_1() 
	{
		ui.mainTextArea.setText("Ikaw ay papalapit sa isang triangular na senyas na may larawan ng dalawang batang naglalakad.\r\n"
				+ "Ano ang tamang ibig sabihin nito?");
		ui.choice1.setText("School Zone Ahead");
		ui.choice2.setText("Pedestrian Lane");
		ui.choice3.setText("No Entry");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct1_1";
		game.nextOption2 = "wrong1_1";
		game.nextOption3 = "wrong1_1";
	}
	
	public void chapter1_2() 
	{
		ui.mainTextArea.setText("Ikaw ay nasa isang intersection na may yellow box. Mabagal ang usad sa harapan.\r\n"
				+ "Ano ang gagawin mo");
		ui.choice1.setText("Pumasok kahit mabagal ang trapiko ");
		ui.choice2.setText("Maghintay sa likod ng yellow box");
		ui.choice3.setText("Bumusina para padapain ang nasa harap");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_2";
		game.nextOption2 = "correct1_2";
		game.nextOption3 = "wrong1_2";
	}
	
	public void chapter1_3() 
	{
		ui.mainTextArea.setText("Habang umaandar, nakita mo ang broken white line sa pagitan ng lanes.\r\n"
				+ "Ano ang ibig sabihin nito?");
		ui.choice1.setText("Pwedeng lumipat ng lane kung ligtas");
		ui.choice2.setText("Bawal lumipat ng lane");
		ui.choice3.setText("No overtaking zone ito");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct1_3";
		game.nextOption2 = "wrong1_3";
		game.nextOption3 = "wrong1_3";
	}
	
	public void chapter1_4() 
	{
		ui.mainTextArea.setText("Ikaw ay dadaan sa pedestrian lane, may tumatawid na matanda pero green ang ilaw.\r\n"
				+ "Ano ang gagawin mo?");
		ui.choice1.setText("Businahan ang pedestrian");
		ui.choice2.setText("Ipagpatuloy ang takbo");
		ui.choice3.setText("Magbigay-daan sa tumatawid");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_4";
		game.nextOption2 = "wrong1_4";
		game.nextOption3 = "correct1_4";
	}
	
	public void chapter1_5() 
	{
		ui.mainTextArea.setText("Ikaw ay nakakita ng solid white line sa gilid ng kalsada.\r\n"
				+ "Ano ang ibig sabihin nito?");
		ui.choice1.setText("Pwedeng tumigil kahit saan");
		ui.choice2.setText("Edge marking – dapat manatili sa loob");
		ui.choice3.setText("Indikasyon ng parking lane");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_5";
		game.nextOption2 = "correct1_5";
		game.nextOption3 = "wrong1_5";
	}
	
	public void chapter1_6() 
	{
		ui.mainTextArea.setText("Habang papaliko, may nakita kang red circular sign na may diagonal line.\r\n"
				+ "Ano ang ibig sabihin nito?");
		ui.choice1.setText("No Entry");
		ui.choice2.setText("Slippery Road");
		ui.choice3.setText("School Crossing");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct1_6";
		game.nextOption2 = "wrong1_6";
		game.nextOption3 = "wrong1_6";
	}
	
	public void chapter1_7() 
	{
		ui.mainTextArea.setText("Ikaw ay papalapit sa blinking yellow traffic light.\r\n"
				+ "Ano ang ibig sabihin nito?");
		ui.choice1.setText("Mag-full stop kahit walang sasakyan");
		ui.choice2.setText("Go na agad");
		ui.choice3.setText("Maghinay-hinay at mag-ingat sa pagtawid ");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_7";
		game.nextOption2 = "wrong1_7";
		game.nextOption3 = "correct1_7";
	}
	
	public void chapter1_8() 
	{
		ui.mainTextArea.setText("May solid double yellow line sa gitna ng kalsada.\r\n"
				+ "Ano ang ibig sabihin nito?");
		ui.choice1.setText("Pwedeng lumiko");
		ui.choice2.setText("No overtaking in both directions");
		ui.choice3.setText("One way lang ang daan");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_8";
		game.nextOption2 = "correct1_8";
		game.nextOption3 = "wrong1_8";
	}
	
	public void chapter1_9() 
	{
		ui.mainTextArea.setText("Ikaw ay nasa stoplight, red ang ilaw. Walang enforcer, walang sasakyan.\r\n"
				+ "Anong tamang kilos?");
		ui.choice1.setText("Mag-U-turn");
		ui.choice2.setText("Maghintay ng green light");
		ui.choice3.setText("Dumiretso agad");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_9";
		game.nextOption2 = "correct1_9";
		game.nextOption3 = "wrong1_9";
	}
	
	public void chapter1_10() 
	{
		ui.mainTextArea.setText("May orange diamond-shaped sign sa kalsada.\r\n"
				+ "Ano ang ibig sabihin nito?");
		ui.choice1.setText("Pwedeng mag-park");
		ui.choice2.setText("Warning sign – maaaring may construction o panganib");
		ui.choice3.setText("Speed limit sign ito");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong1_10";
		game.nextOption2 = "correct1_10";
		game.nextOption3 = "wrong1_10";
	}
	
	public void chapter1_result() 
	{
		if (player.xp==20) 
		{
			ui.mainTextArea.setText("CONGRATULATIONS! CHAPTER ONE DONE\r\n"
					+ "XP GAINED: " + player.xp + "\r\n"
					+ "BADGE OBTAINED: Sign Reader");
			player.badge = new Badge_SignReader();
			ui.badgeNameLabel.setText(player.badge.name);
			
			ui.choice1.setText("CONTINUE CHAPTER 2");
			ui.choice2.setText("QUIT GAME");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			ui.choice1.setVisible(true);
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(false);
			
			game.nextOption1 = "chapter2";
			game.nextOption2 = "quitGame";
		}
		else 
		{
			ui.mainTextArea.setText("I'm sorry, but you didn't get the perfect xp needed. You have to retake the previous chapter to proceed to the next chapter\r\n"
					+ "						 ON THE ROAD, OUR SAFETY DEPENDS ON US—MISTAKES ARE NOT TOLERATED.\r\n"
					+ "");
			
			ui.choice1.setText("RETAKE CHAPTER 1");
			ui.choice2.setText("QUIT GAME");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			ui.choice1.setVisible(true);
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(false);
			
			player.xp = 0;
			ui.xpNumberLabel.setText("" + player.xp);
			
			game.nextOption1 = "chapter1";
			game.nextOption2 = "quitGame";
		}
	}
	
	public void chapter2() 
	{
		ui.mainTextArea.setText("Kabanata 2: Bago Umarangkada");
		ui.choice1.setText("Magpatuloy");
		ui.choice2.setText("QUIT GAME");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "chapter2.1";
		game.nextOption2 = "quitGame";
	}
	
	public void chapter2_1() 
	{
		ui.mainTextArea.setText("Bago bumiyahe, ano ang dapat unang tignan sa gulong?");
		ui.choice1.setText("Presyon ng hangin sa gulong ");
		ui.choice2.setText("Laki ng gulong");
		ui.choice3.setText("Kulay ng gulong");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct2_1";
		game.nextOption2 = "wrong2_1";
		game.nextOption3 = "wrong2_1";
	}
	
	public void chapter2_2() 
	{
		ui.mainTextArea.setText("Habang nagmamaneho, biglang umusok ang makina. Ano ang tamang gawin?");
		ui.choice1.setText("Buksan agad ang radiator cap ");
		ui.choice2.setText("Huminto at patayin ang makina");
		ui.choice3.setText("Ituloy ang pagmamaneho\r\n");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_2";
		game.nextOption2 = "correct2_2";
		game.nextOption3 = "wrong2_2";
	}
	
	public void chapter2_3() 
	{
		ui.mainTextArea.setText("Anong ilaw ang dapat gamitin sa gabi?");
		ui.choice1.setText("Headlight ");
		ui.choice2.setText("Signal light");
		ui.choice3.setText("Hazard light");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct2_3";
		game.nextOption2 = "wrong2_3";
		game.nextOption3 = "wrong2_3";
	}
	
	public void chapter2_4() 
	{
		ui.mainTextArea.setText("Paano masisigurong maayos ang preno?");
		ui.choice1.setText("Ipagdasal na lang");
		ui.choice2.setText(" Di na kailangan kung maingat ka mag-drive");
		ui.choice3.setText("Subukin bago bumiyahe");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_4";
		game.nextOption2 = "wrong2_4";
		game.nextOption3 = "correct2_4";
	}
	
	public void chapter2_5() 
	{
		ui.mainTextArea.setText("May tubig sa kalsada, anong dapat gawin?");
		ui.choice1.setText("I-off ang ilaw");
		ui.choice2.setText("Magmenor at iwasan kung malalim");
		ui.choice3.setText(" Magbusina ng tuloy-tuloy");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_5";
		game.nextOption2 = "correct2_5";
		game.nextOption3 = "wrong2_5";
	}
	
	public void chapter2_6() 
	{
		ui.mainTextArea.setText("May gasgas ang salamin sa harap, anong epekto nito?");
		ui.choice1.setText("Bawas visibility at delikado");
		ui.choice2.setText("Aesthetic lang");
		ui.choice3.setText("Pampaswerte");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct2_6";
		game.nextOption2 = "wrong2_6";
		game.nextOption3 = "wrong2_6";
	}
	
	public void chapter2_7() 
	{
		ui.mainTextArea.setText("Ano ang tawag sa ilaw na ginagamit kapag biglang hinto?");
		ui.choice1.setText("Signal light");
		ui.choice2.setText("Headlight");
		ui.choice3.setText("Hazard light");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_7";
		game.nextOption2 = "wrong2_7";
		game.nextOption3 = "correct2_7";
	}
	
	public void chapter2_8() 
	{
		ui.mainTextArea.setText("Ano ang ideal na distansya sa sinusundang sasakyan?");
		ui.choice1.setText("1 metro");
		ui.choice2.setText("3-second rule");
		ui.choice3.setText("10 segundo");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_8";
		game.nextOption2 = "correct2_8";
		game.nextOption3 = "wrong2_8";
	}
	
	public void chapter2_9() 
	{
		ui.mainTextArea.setText("Paano mo mapapansin kung may problema sa baterya?");
		ui.choice1.setText("Maingay ang gulong");
		ui.choice2.setText("Hirap mag-start ang sasakyan");
		ui.choice3.setText("Malamig ang aircon");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_9";
		game.nextOption2 = "correct2_9";
		game.nextOption3 = "wrong2_9";
	}
	
	public void chapter2_10() 
	{
		ui.mainTextArea.setText("May kasabay kang estudyante. Natanong niya kung paano malalaman kung ligtas pa ang brake fluid. Anong sagot mo?");
		ui.choice1.setText("Tikman ito");
		ui.choice2.setText("Suriin ang antas gamit ang dipstick");
		ui.choice3.setText("Ipagdasal ulit");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong2_10";
		game.nextOption2 = "correct2_10";
		game.nextOption3 = "wrong2_10";
	}
	
	public void chapter2_result() 
	{
		if (player.xp==40) 
		{
			ui.mainTextArea.setText("CONGRATULATIONS! CHAPTER ONE DONE\r\n"
					+ "XP GAINED: " + player.xp + "\r\n"
					+ "BADGE OBTAINED: Safety First");
			player.badge = new Badge_SafetyFirst();
			ui.badgeNameLabel.setText(player.badge.name);
			
			ui.choice1.setText("CONTINUE CHAPTER 3");
			ui.choice2.setText("QUIT GAME");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			ui.choice1.setVisible(true);
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(false);
			
			game.nextOption1 = "chapter3";
			game.nextOption2 = "quitGame";
		}
		else 
		{
			ui.mainTextArea.setText("I'm sorry, but you didn't get the perfect xp needed. You have to retake the previous chapter to proceed to the next chapter\r\n"
					+ "						 ON THE ROAD, OUR SAFETY DEPENDS ON US—MISTAKES ARE NOT TOLERATED.\r\n"
					+ "");
			
			ui.choice1.setText("RETAKE CHAPTER 2");
			ui.choice2.setText("QUIT GAME");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			ui.choice1.setVisible(true);
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(false);
			
			player.xp = 20;
			ui.xpNumberLabel.setText("" + player.xp);
			
			game.nextOption1 = "chapter2";
			game.nextOption2 = "quitGame";
		}
	}
	
	public void chapter3() 
	{
		ui.mainTextArea.setText("Kabanata 3: Alamin ang Batas");
		ui.choice1.setText("Magpatuloy");
		ui.choice2.setText("QUIT GAME");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "chapter3.1";
		game.nextOption2 = "quitGame";
	}
	
	public void chapter3_1() 
	{
		ui.mainTextArea.setText("Anong klaseng lisensya ang kailangan para sa pampasaherong sasakyan?");
		ui.choice1.setText("Professional Driver’s License");
		ui.choice2.setText("Student Permit");
		ui.choice3.setText("Non-Pro License");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct3_1";
		game.nextOption2 = "wrong3_1";
		game.nextOption3 = "wrong3_1";
	}
	
	public void chapter3_2() 
	{
		ui.mainTextArea.setText("Ano ang parusa sa hindi pagsusuot ng seatbelt?");
		ui.choice1.setText("Warning lang");
		ui.choice2.setText("Multa at puntos sa lisensya");
		ui.choice3.setText("Walang parusa");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_2";
		game.nextOption2 = "correct3_2";
		game.nextOption3 = "wrong3_2";
	}
	
	public void chapter3_3() 
	{
		ui.mainTextArea.setText("Ilang taon ang minimum age para makakuha ng Student Permit?");
		ui.choice1.setText("16 taon");
		ui.choice2.setText("15 taon");
		ui.choice3.setText("18 taon");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct3_3";
		game.nextOption2 = "wrong3_3";
		game.nextOption3 = "wrong3_3";
	}
	
	public void chapter3_4() 
	{
		ui.mainTextArea.setText("Anong batas ang nagsasaad ng Child Safety in Motor Vehicles?");
		ui.choice1.setText("RA 4136");
		ui.choice2.setText("RA 8794");
		ui.choice3.setText("RA 11229");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_4";
		game.nextOption2 = "wrong3_4";
		game.nextOption3 = "correct3_4";
	}
	
	public void chapter3_5() 
	{
		ui.mainTextArea.setText("May checkpoint at hinihingan ka ng \"pang-kape.\" Ano ang tamang tugon?");
		ui.choice1.setText("Bigyan ng pera");
		ui.choice2.setText("Humingi ng formal na ticket");
		ui.choice3.setText("Umiwas");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_5";
		game.nextOption2 = "correct3_5";
		game.nextOption3 = "wrong3_5";
	}
	
	public void chapter3_6() 
	{
		ui.mainTextArea.setText("Anong violation kung lumampas ka sa solid yellow line?");
		ui.choice1.setText("Illegal overtaking");
		ui.choice2.setText("Speeding");
		ui.choice3.setText("Overloading");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "correct3_6";
		game.nextOption2 = "wrong3_6";
		game.nextOption3 = "wrong3_6";
	}
	
	public void chapter3_7() 
	{
		ui.mainTextArea.setText("Ano ang dapat gawin sa pedestrian lane?");
		ui.choice1.setText("Bilisan ang takbo");
		ui.choice2.setText("Businahan ang tumatawid");
		ui.choice3.setText("Magbigay-daan");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_7";
		game.nextOption2 = "wrong3_7";
		game.nextOption3 = "correct3_7";
	}
	
	public void chapter3_8() 
	{
		ui.mainTextArea.setText("Kailan dapat gumamit ng signal light?");
		ui.choice1.setText("Kapag gabi");
		ui.choice2.setText("Bago lumiko o magpalit ng lane");
		ui.choice3.setText("Pagkabitin lang\r\n");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_8";
		game.nextOption2 = "correct3_8";
		game.nextOption3 = "wrong3_8";
	}
	
	public void chapter3_9() 
	{
		ui.mainTextArea.setText("Anong klaseng violation kung hindi naka-rehistro ang sasakyan?");
		ui.choice1.setText("Minor");
		ui.choice2.setText("Major traffic offense");
		ui.choice3.setText("Warning lang");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_9";
		game.nextOption2 = "correct3_9";
		game.nextOption3 = "wrong3_9";
	}
	
	public void chapter3_10() 
	{
		ui.mainTextArea.setText("Kung nahuli ka at alam mong mali ka, ano ang dapat gawin?");
		ui.choice1.setText("Tumakas");
		ui.choice2.setText("Tanggapin ang ticket at umapela kung kinakailangan");
		ui.choice3.setText("Magmakaawa");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "wrong3_10";
		game.nextOption2 = "correct3_10";
		game.nextOption3 = "wrong3_10";
	}
	
	public void chapter3_result() 
	{
		if (player.xp==60) 
		{
			ui.mainTextArea.setText("CONGRATULATIONS! CHAPTER ONE DONE\r\n"
					+ "XP GAINED: " + player.xp + "\r\n"
					+ "BADGE OBTAINED: Integrity Badge");
			player.badge = new IntegrityBadge();
			ui.badgeNameLabel.setText(player.badge.name);
			
			ui.choice1.setText("CONTINUE");
			ui.choice2.setText("QUIT GAME");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			ui.choice1.setVisible(true);
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(false);
			
			game.nextOption1 = "final";
			game.nextOption2 = "quitGame";
		}
		else 
		{
			ui.mainTextArea.setText("I'm sorry, but you didn't get the perfect xp needed. You have to retake the previous chapter to proceed to the next chapter\r\n"
					+ "						 ON THE ROAD, OUR SAFETY DEPENDS ON US—MISTAKES ARE NOT TOLERATED.\r\n"
					+ "");
			
			ui.choice1.setText("RETAKE CHAPTER 3");
			ui.choice2.setText("QUIT GAME");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			ui.choice1.setVisible(true);
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(false);
			
			player.xp = 20;
			ui.xpNumberLabel.setText("" + player.xp);
			
			game.nextOption1 = "chapter3";
			game.nextOption2 = "quitGame";
		}
	}
	
	public void finalPage() 
	{
		ui.mainTextArea.setText("CONGRATULATIONS! YOU'VE FINISHED THE GAME\n\n"
				+ "\tGAINED XP : 60\n\n"
				+ "\tOBTAINED BADGES : Sign Reader\n"
				+ "\t                  Safety First\n"
				+ "\t                  Integrity Badge\n");
		
		ui.choice1.setText("RESTART GAME");
		ui.choice2.setText("BACK");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextOption1 = "chapter1";
		game.nextOption2 = "back";
	}
}
