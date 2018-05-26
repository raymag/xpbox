/*
 * Gerador de Personagem - V4.1.
 * Escrito por Raymag.
 */
package charactergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import plusinfo.*;

/**
 *
 * @author Mag
 */
public class CharacterGenerator extends javax.swing.JFrame {

    int mod; //Modifier that balances the attributes
    boolean chooseBreed = false;
    boolean chooseClass = false;
    int breedMaxIndex = 3; //Max Index of Breeds List
    int classMaxIndex = 15; //Max Index of Classes List
    int rMaxIndex = 9; //Max Index of HomeLands List
    String r[] = {"Ali Hana", "Duoss", "Qocient", "Los Andes",
        "Monte Carlo", "F. Atalante", "Egito", "Kanas", "Brasília", "Tryna"};
    List<String> skills = new ArrayList<String>();
    SkillsFrame sk = new SkillsFrame();
    //SKILLS INFO ===>
    String Esfaquear[] = {"Esfaquear","Lâminas Curtas", "Ladina, etc", "Passiva", "Básica",
        "Faz movimentos rápidos e amplos com a lâmina<br/> a fim de realizar cortes"
            + " e hemorragias no alvo.", "1 M",
            "+1 Em rolagens de dano e teste para ataques<br/> com lâminas pequenas."
            + " 30% de chance de<br/> aplicar hemorragia (Causa 1 de dano ao alvo, a cada 2 turnos)."};
    String Dilacerar[] = {"Dilacerar", "Lâminas Longas", "Guerreira, etc", "Passiva", "Básica",
    "Realiza ataques amplos e longos com a espada, a fim de manter a ofensiva e dilacerar o alvo.",
    "Dep. Arma", "+1 Em rolagens de dano e teste para ataques<br/> com espadas e lâminas grandes."};
    String ControlarOrb[] = {"Controlar Orb", "Orbs Mágicos", "Mago", "Ativa", "Básica",
    "Utiliza de seu Chi e concentração para levitar e controlar um Orb Mágico.", "50 M", "Um Orb só pode"
            + "ser controlado enquanto <br/> estiver no campo de visão do portador. Além disso, não é "
            + "possível utilizar um Orb sem concentração e foco."};
    String DispararFlecha[] = {"Disparar Flecha", "Arcos, Bestas, etc", "Ranger", "Passiva", "Básica",
    "Utiliza de sua concentração e técnica para disparar<br/> flechas em direção ao alvo.",
    "60 M", "+1 em rolagens para de teste<br/> e +2 em rolagens de dano."};
    String Revitalizar[] = {"Revitalizar", "Mão, Catalizadores", "Druida", "Ativa", "Básica",
    "O usuário direciona um feixe de luz solar ou lunar concentrado no alvo. A força provida pela luz<br/>revitaliza o"
            + " alvo, curando seus ferimentos e<br/> energizando seu corpo.",
    "30 M", "Consume 1D6 de MP, e recupera a mesma <br/> quantidade de HP do alvo."
            + " Bônus: +1 HP por luz solar, e redução de 1 ponto<br/> no consumo de MP. Não funciona em locais"
            + " sem<br/> luz solar ou lunar."};
    String FalcaoFloresta[] = {"Falcão da Floresta", "---", "Druida", "Ativa", "Básica", "O usuário converte a sua forma "
            + "física em um grande falcão da floresta. Aumentando sua velocidade, mobilidade e campo de visão.",
    "---", "Consome 5 MPs para se converter em falcão por no máximo 3 turnos por vez. A velocidade e campo de visão são"
            + " melhoradas, mas a defesa e resistência física é degradada."};
    String Purificar[] = {"Purificar", "Mão Livre", "Paladina, Sacerdote", "Ativa", "Básica",
    "O usuário em castidade, toca o alvo e o purifica. Curando parte de seus ferimentos<br/> e dispersando maldições e"
            + " posseções.", "0.6 M", "Consome 5 MPs, Disperça maldições simples, e recupera 1D6 HPs do alvo. Caso o alvo seja um <br/>"
            + " Morto-Vivo ou algum ser impuro, serão infligidos 1D6 HPs ao invés da cura."};
    String AtivarOrb[] = {"Ativar Orb", "Orb Mágico", "Mago", "Ativa", "Básica",
    "Ao influir chi e concentração no cristal do orb, o usuário ativa a propriedade física-elemental do mesmo.",
    "50 M", "Com um consumo de 1 MP por turno, ativar a propriedade física elemental do orb pode ter diferentes efeitos"
            + " a depender do orb e do usuário."};
    String Furtivo[] = {"Furtivo", "---", "Ladina", "Ativa", "Básica",
    "O usuário se esgueira e adota técnicas furtivas, abafando seus sons, chi, e presença.", "---",
    "Ao entrar em modo furtivo, o usuário ficará quase indetectável enquanto estiver fora do campo de visão do alvo e "
            + "não fizer barulhos altos. Ao ativar este modo, é necessário definir o nível de furtividade com 2D6+DEX."
            + " Ataques realizados no modo furtivo terão um adicional de +2 em dano, e 100% de chance de acerto, caso"
            + " seja um ataque de curta distância."};
    /**
     * Creates new form CharacterGenerator
     */
    public CharacterGenerator() {
        initComponents();
    }
    
    /** Enables or disables Breed JComboBox */
    public void breedDisabled(){
        if(chooseBreed){
            cbBreed.setEnabled(false);
            chooseBreed = false;
        }else{
            cbBreed.setEnabled(true);
            chooseBreed = true;
        }
    }
    
    /** Enables or disables Class JComboBox */
    public void classDisabled(){
        if(chooseClass){
            cbClass.setEnabled(false);
            chooseClass = false;
        }else{
            cbClass.setEnabled(true);
            chooseClass = true;
        }
    }
    
    /** Sets basic character attributes (For, Dex, Vit, Int, Per, Car) */
    public void setBasicAttributes(){
        lbForValue.setText(String.valueOf(RandomValue()));
        lbDexValue.setText(String.valueOf(RandomValue()));
        lbVitValue.setText(String.valueOf(RandomValue()));
        lbIntValue.setText(String.valueOf(RandomValue()));
        lbPerValue.setText(String.valueOf(RandomValue()));
        lbCarValue.setText(String.valueOf(RandomValue()));
    }
    
    /** Sets dependent character attributes (HP, DF and MP) */
    public void setDependentAttributes(){
        lbHpValue.setText(String.valueOf( 10 + Integer.parseInt(lbVitValue.getText()) ));
        lbDfValue.setText(String.valueOf( (( Integer.parseInt(lbDexValue.getText()) + Integer.parseInt(lbVitValue.getText()) )/2) ));
        lbMpValue.setText( String.valueOf( 10 + ( 2*Integer.parseInt(lbIntValue.getText()) ) ) );
    }
    
    /** Applies class modifiers to character attributes */
    public void applyBreedMods(){
        switch(cbBreed.getSelectedIndex()){
                case 1: //Anã
                    //System.out.println(lbVitValue.getText());
                    lbVitValue.setText( String.valueOf( Integer.parseInt(lbVitValue.getText())+1 ) );
                    //System.out.println(lbVitValue.getText());
                    //System.out.println(lbPerValue.getText());
                    lbPerValue.setText( String.valueOf( Integer.parseInt(lbPerValue.getText())-1 ) );
                    //System.out.println(lbPerValue.getText());
                    break;
                case 2: //Élfica
                    //System.out.println(lbIntValue.getText());
                    lbIntValue.setText( String.valueOf( Integer.parseInt(lbIntValue.getText())+1 ) );
                    //System.out.println(lbIntValue.getText());
                    //System.out.println(lbForValue.getText());
                    lbForValue.setText( String.valueOf( Integer.parseInt(lbForValue.getText())-1 ) );
                    //System.out.println(lbForValue.getText());
                    break;
                case 3://Orc
                    //System.out.println(lbForValue.getText());
                    lbForValue.setText( String.valueOf( Integer.parseInt(lbForValue.getText())+1 ) );
                    //System.out.println(lbForValue.getText());
                    //System.out.println(lbCarValue.getText());
                    lbCarValue.setText( String.valueOf( Integer.parseInt(lbCarValue.getText())-1 ) );
                    //System.out.println(lbCarValue.getText());
                    break;
                }
    }
    
    /** Sets random and secondary character values (Age, breed, class and homeland) */
    public void setRandomValues(){
        Random gen = new Random();
        lbAgeValue.setText(String.valueOf( 15+gen.nextInt(8) ));
            
        if(btBreed.getModel().isSelected() == false){
            cbBreed.setSelectedIndex(gen.nextInt(breedMaxIndex));
        }
        if(btClass.getModel().isSelected()==false){
            cbClass.setSelectedIndex(gen.nextInt(classMaxIndex));
        }
        lbBreed.setText(String.valueOf(cbBreed.getSelectedItem()));
        lbClassValue.setText(String.valueOf(cbClass.getSelectedItem()));
        lbHome.setText( r[gen.nextInt(rMaxIndex)] );
    }
    
    /** Removes all character skills */
    public void resetSkills(){
        cbSkills.removeAllItems();
        skills.removeAll(skills);
    }
    
    /** Sets character skills */
    public void setSkills(){
        /*System.out.println(String.valueOf(cbSkills.getSelectedItem() ) );
        System.out.println(skills.get(cbSkills.getSelectedIndex()));*/
        switch(cbClass.getSelectedIndex()){
            case 0: //Guerreira
                cbSkills.addItem("Dilacerar");
                skills.add("Dilacerar");
                cbSkills.addItem("Resistir");
                skills.add("Resistir");
                cbSkills.addItem("Neutralizar");//maos livres
                skills.add("Neutralizar");
                cbSkills.addItem("Liderar");//buff
                skills.add("Liderar");
                cbSkills.addItem("Spinner Blade");//POR DEMACIA!
                skills.add("Spinner Blade");
            case 1: //Ladina
                cbSkills.addItem("Esfaquear");
                skills.add("Esfaquear");
                cbSkills.addItem("Furtivo");
                skills.add("Furtivo");
                cbSkills.addItem("Furtar");
                skills.add("Furtar");
                cbSkills.addItem("Mentir");
                skills.add("Mentir");
                cbSkills.addItem("Persuadir");
                skills.add("Persuadir");
                cbSkills.addItem("Apunhalar");
                skills.add("Apunhalar");
                cbSkills.addItem("Acrobata");
                skills.add("Acrobata");
                //System.out.println(skills.get(0));
                break;
            case 2: //Mago
                cbSkills.addItem("Controlar Orb");
                skills.add("Controlar Orb");
                cbSkills.addItem("AtivarOrb");
                skills.add("AtivarOrb");
                cbSkills.addItem("Maxmizar");
                skills.add("Maximizar");
                cbSkills.addItem("Concentrar-Chi");
                skills.add("Concentrar-Chi");
                cbSkills.addItem("Duo");//Usar dois orbs de mesma classe
                skills.add("Duo");
                break;
            case 3: //Druida
                cbSkills.addItem("Esfaquear");
                skills.add("Esfaquear");
                cbSkills.addItem("Revitalizar");
                skills.add("Revitalizar");
                cbSkills.addItem("FalcaoFloresta");
                skills.add("FalcaoFloresta");
                cbSkills.addItem("Germinar");//Se converte em arvore
                skills.add("Germinar");//se cura
                cbSkills.addItem("Drenar Natureza");//Drena a energia
                skills.add("Drenar Natureza");//Da mae terra para maximizar poder
                cbSkills.addItem("Convocar Animais");
                skills.add("Convocar Animais");
                cbSkills.addItem("Fogo Solar");//queima
                skills.add("Fogo Solar");
                cbSkills.addItem("Fogo Lunar");//blind
                skills.add("Fogo Lunar");
                break;
            case 4://Paladina, etc;
                cbSkills.addItem("Dilacerar");
                skills.add("Dilacerar");
                cbSkills.addItem("Purificar");
                skills.add("Purificar");
                cbSkills.addItem("Excalibur");//Espada de Luz
                skills.add("Excalibur");
                cbSkills.addItem("Iluminado");//aumenta todos os status
                skills.add("Iluminado");//aplica cura constante
                break;
            case 5://Ranger
                cbSkills.addItem("Esfaquear");
                skills.add("Esfaquear");
                skills.add("Disparar Flecha");
                cbSkills.addItem("Disparar Flecha");
                cbSkills.addItem("Rastrear");
                skills.add("Rastrear");
                cbSkills.addItem("Aplicar Alvo");//+precisao
                skills.add("Aplicar Alvo");
                cbSkills.addItem("Neutralizar");
                skills.add("Neutralizar");
            case 6://Clériga
                cbSkills.addItem("Purificar");
                skills.add("Purificar");
                cbSkills.addItem("Amaldiçoar");
                skills.add("Amaldiçoar");
                cbSkills.addItem("Luz do Deserto");
                skills.add("Luz do Deserto");
                cbSkills.addItem("Noite da Tormenta");//convoca tempestada
                skills.add("Noite da Tormaneta");
                cbSkills.addItem("Praga do Gato Negro");//azar
                skills.add("Praga do Gato Negro");
                break;
            case 7://Barda
                cbSkills.addItem("Dilacerar");
                skills.add("Dilacerar");
                cbSkills.addItem("Inspirar");//Depende do instrumento
                skills.add("Inspirar");
                cbSkills.addItem("Contagiar");
                skills.add("Contagiar");
                cbSkills.addItem("Cantiga Triste");
                skills.add("Cantida Triste");
                cbSkills.addItem("Rompe Tormentas");//Golpe de Animo
                skills.add("Rompe Tormentas");
                break;
            case 8://Fantasma, muda parcialmente as propriedades de seu corpo
                cbSkills.addItem("Esfaquear");
                skills.add("Esfaquear");
                cbSkills.addItem("Transparecer");//Luz visível passa
                skills.add("Transparecer");//Mas enxerga em infra-vermelho
                cbSkills.addItem("Infra-Vermelho");
                skills.add("Infra-Vermelho");
                break;
            case 9://Necromante
                cbSkills.addItem("Dark FireBall");//Fireball roxa/negra
                skills.add("Dark FireBall");
                cbSkills.addItem("Vampire Fangs");//Presas de vampiro, hp em mp
                skills.add("Vampire Fangs");
                cbSkills.addItem("Summon Undead");//Convocar os mortos
                skills.add("Summon Undead");
                break;
            case 10://Domador
                cbSkills.addItem("Whipping");//Chicotada
                skills.add("Whipping");
                cbSkills.addItem("Disparar Flecha");
                skills.add("Disparar Flecha");
                cbSkills.addItem("Acalmar Fera");
                skills.add("Acalmar Fera");
                cbSkills.addItem("Seduzir Besta");
                skills.add("Seduzir Besta");
                cbSkills.addItem("Coleira da Besta");
                skills.add("Coleira da Besta");
                cbSkills.addItem("Elo Espiritual");
                skills.add("Elo Espiritual");
                cbSkills.addItem("Detectar Besta");
                skills.add("Detectar Besta");
                break;
            case 11://Feiticeira, +forte c/ homens
                cbSkills.addItem("Feline Claw");//Ataca com garras, unhas
                skills.add("Feline Claw");
                cbSkills.addItem("Death Kiss");//Drena energia vital
                skills.add("Death Kiss");
                cbSkills.addItem("Seduzir");//Acalma, Baixa a guarda do alvo
                skills.add("Seduzir");
                cbSkills.addItem("Induzir");//Faz sugestões a homens seduzidos (teste facil)
                skills.add("Induzir");
                cbSkills.addItem("Imperatriz");//(Teste HARDCORE) que torna homens seduzidos escravos
                skills.add("Imperatriz");
                cbSkills.addItem("Grãos-Ocitocina");//Chance de fazer homens se apaixonarem
                skills.add("Grãos-Ocitocina");
                cbSkills.addItem("Death Fangs"); //Em um ato de amor, arranca as veias e tendoes do pescoço do alvo
                skills.add("Death Fangs");
                break;
            case 12://Monge
                break;
            case 13://Ilusionista
                cbSkills.addItem("Esfaquear");
                skills.add("Esfaquear");
                cbSkills.addItem("Não-Está-Aqui");
                skills.add("Não-Está-Aqui");
                cbSkills.addItem("Fingir-Morte");
                skills.add("Fingir-Morte");
                cbSkills.addItem("Assustar");
                skills.add("Assustar");
                cbSkills.addItem("Seduzir");//c/ sonhos
                skills.add("Seduzir");
                cbSkills.addItem("Dream Door");
                skills.add("Dream Door");
                break;
            case 14://Mentalista
                cbSkills.addItem("Canalizar");
                skills.add("Canalizar");
                cbSkills.addItem("Lâmina-Invisível");
                skills.add("Lâmina-Invisível");
                cbSkills.addItem("Campo de Força");
                skills.add("Campo de Força");
                cbSkills.addItem("Fortificar");
                skills.add("Fortificar");
                cbSkills.addItem("Invisible Pulse");
                skills.add("Invisible Pulse");
                break;
            default://Guerreira, etc;
                /*cbSkills.addItem("Dilacerar");
                skills.add("Dilacerar");*/
                break;
        }
    }
    
    /**
     * Chooses attribute values in a balanced way (Using attribute modifier).
     */
    public int RandomValue(){
        Random gerador = new Random();
        return gerador.nextInt(6)+mod;
    }

    public void setSkInfo(){
            if(String.valueOf(cbSkills.getSelectedItem())=="Esfaquear"){
                sk.clbSkillTitle(Esfaquear[0]);
                sk.clbRequiredValue(Esfaquear[1]);
                sk.clbClassValue(Esfaquear[2]);
                sk.clbTypeValue(Esfaquear[3]);
                sk.clbLevelValue(Esfaquear[4]);
                sk.clbDesc("<html>Descrição: "+Esfaquear[5]);
                sk.clbMaxDistValue(Esfaquear[6]);
                sk.clbFx("<html>Efeitos: "+Esfaquear[7]);
            }
            if(String.valueOf(cbSkills.getSelectedItem())=="Dilacerar"){
                sk.clbSkillTitle(Dilacerar[0]);
                sk.clbRequiredValue(Dilacerar[1]);
                sk.clbClassValue(Dilacerar[2]);
                sk.clbTypeValue(Dilacerar[3]);
                sk.clbLevelValue(Dilacerar[4]);
                sk.clbDesc("<html>Descrição: "+Dilacerar[5]);
                sk.clbMaxDistValue(Dilacerar[6]);
                sk.clbFx("<html>Efeitos: "+Dilacerar[7]);
            }
            if(String.valueOf(cbSkills.getSelectedItem())=="Controlar Orb"){
                sk.clbSkillTitle(ControlarOrb[0]);
                sk.clbRequiredValue(ControlarOrb[1]);
                sk.clbClassValue(ControlarOrb[2]);
                sk.clbTypeValue(ControlarOrb[3]);
                sk.clbLevelValue(ControlarOrb[4]);
                sk.clbDesc("<html>Descrição: "+ControlarOrb[5]);
                sk.clbMaxDistValue(ControlarOrb[6]);
                sk.clbFx("<html>Efeitos: "+ControlarOrb[7]);
           }
            if(String.valueOf(cbSkills.getSelectedItem())=="Disparar Flecha"){
                sk.clbSkillTitle(DispararFlecha[0]);
                sk.clbRequiredValue(DispararFlecha[1]);
                sk.clbClassValue(DispararFlecha[2]);
                sk.clbTypeValue(DispararFlecha[3]);
                sk.clbLevelValue(DispararFlecha[4]);
                sk.clbDesc("<html>Descrição: "+DispararFlecha[5]);
                sk.clbMaxDistValue(DispararFlecha[6]);
                sk.clbFx("<html>Efeitos: "+DispararFlecha[7]);
           }
           if(String.valueOf(cbSkills.getSelectedItem())=="Revitalizar"){
                sk.clbSkillTitle(Revitalizar[0]);
                sk.clbRequiredValue(Revitalizar[1]);
                sk.clbClassValue(Revitalizar[2]);
                sk.clbTypeValue(Revitalizar[3]);
                sk.clbLevelValue(Revitalizar[4]);
                sk.clbDesc("<html>Descrição: "+Revitalizar[5]);
                sk.clbMaxDistValue(Revitalizar[6]);
                sk.clbFx("<html>Efeitos: "+Revitalizar[7]);
           }
           if(String.valueOf(cbSkills.getSelectedItem())=="Purificar"){
                sk.clbSkillTitle(Purificar[0]);
                sk.clbRequiredValue(Purificar[1]);
                sk.clbClassValue(Purificar[2]);
                sk.clbTypeValue(Purificar[3]);
                sk.clbLevelValue(Purificar[4]);
                sk.clbDesc("<html>Descrição: "+Purificar[5]);
                sk.clbMaxDistValue(Purificar[6]);
                sk.clbFx("<html>Efeitos: "+Purificar[7]);
           }
           if(String.valueOf(cbSkills.getSelectedItem())=="AtivarOrb"){
                sk.clbSkillTitle(AtivarOrb[0]);
                sk.clbRequiredValue(AtivarOrb[1]);
                sk.clbClassValue(AtivarOrb[2]);
                sk.clbTypeValue(AtivarOrb[3]);
                sk.clbLevelValue(AtivarOrb[4]);
                sk.clbDesc("<html>Descrição: "+AtivarOrb[5]);
                sk.clbMaxDistValue(AtivarOrb[6]);
                sk.clbFx("<html>Efeitos: "+AtivarOrb[7]);
           }
           if(String.valueOf(cbSkills.getSelectedItem())=="Furtivo"){
                sk.clbSkillTitle(Furtivo[0]);
                sk.clbRequiredValue(Furtivo[1]);
                sk.clbClassValue(Furtivo[2]);
                sk.clbTypeValue(Furtivo[3]);
                sk.clbLevelValue(Furtivo[4]);
                sk.clbDesc("<html>Descrição: "+Furtivo[5]);
                sk.clbMaxDistValue(AtivarOrb[6]);
                sk.clbFx("<html>Efeitos: "+Furtivo[7]);
           }
           if(String.valueOf(cbSkills.getSelectedItem())=="FalcaoFloresta"){
                sk.clbSkillTitle(FalcaoFloresta[0]);
                sk.clbRequiredValue(FalcaoFloresta[1]);
                sk.clbClassValue(FalcaoFloresta[2]);
                sk.clbTypeValue(FalcaoFloresta[3]);
                sk.clbLevelValue(FalcaoFloresta[4]);
                sk.clbDesc("<html>Descrição: "+FalcaoFloresta[5]);
                sk.clbMaxDistValue(FalcaoFloresta[6]);
                sk.clbFx("<html>Efeitos: "+FalcaoFloresta[7]);
           }
    }
    
    public void soon(){
        JOptionPane.showMessageDialog(null, "Funcionalidade em Construção.");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGenerate = new javax.swing.JButton();
        lbDex = new javax.swing.JLabel();
        lbVit = new javax.swing.JLabel();
        lbFor = new javax.swing.JLabel();
        lbInt = new javax.swing.JLabel();
        lbPer = new javax.swing.JLabel();
        lbCar = new javax.swing.JLabel();
        lbForValue = new javax.swing.JLabel();
        lbDexValue = new javax.swing.JLabel();
        lbVitValue = new javax.swing.JLabel();
        lbIntValue = new javax.swing.JLabel();
        lbPerValue = new javax.swing.JLabel();
        lbCarValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbHpValue = new javax.swing.JLabel();
        lbDfValue = new javax.swing.JLabel();
        lbMod = new javax.swing.JLabel();
        tfMod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbBreed = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbAgeValue = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        btBreed = new javax.swing.JToggleButton();
        cbBreed = new javax.swing.JComboBox<>();
        cbClass = new javax.swing.JComboBox<>();
        btClass = new javax.swing.JToggleButton();
        lbClass = new javax.swing.JLabel();
        lbClassValue = new javax.swing.JLabel();
        lbMpValue = new javax.swing.JLabel();
        lbMp = new javax.swing.JLabel();
        btSkills = new javax.swing.JButton();
        cbSkills = new javax.swing.JComboBox<>();
        lbSkills = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btInfoBreed = new javax.swing.JButton();
        btInfoClass = new javax.swing.JButton();
        btInfoHomeland = new javax.swing.JButton();
        btInfoAttr = new javax.swing.JButton();
        btInfoPangeia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerador de Personagem");
        setBackground(new java.awt.Color(102, 102, 102));
        setName("Main"); // NOI18N
        setResizable(false);

        btGenerate.setBackground(new java.awt.Color(111, 145, 214));
        btGenerate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btGenerate.setText("Gerar Personagem");
        btGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerateActionPerformed(evt);
            }
        });

        lbDex.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbDex.setText("Destreza:");

        lbVit.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbVit.setText("Vitalidade:");

        lbFor.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbFor.setText("Força:");

        lbInt.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbInt.setText("Inteligência:");

        lbPer.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbPer.setText("Percepção:");

        lbCar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbCar.setText("Carisma:");

        lbForValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbForValue.setText("??");

        lbDexValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbDexValue.setText("??");

        lbVitValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbVitValue.setText("??");

        lbIntValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbIntValue.setText("??");

        lbPerValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbPerValue.setText("??");

        lbCarValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbCarValue.setText("??");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("HP:");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("DF:");

        lbHpValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbHpValue.setText("??");

        lbDfValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbDfValue.setText("??");

        lbMod.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbMod.setText("Modificador:");

        tfMod.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tfMod.setText("1");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Raça:");

        lbBreed.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbBreed.setText("Desconhecida");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Idade:");

        lbAgeValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbAgeValue.setText("??");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Terra Natal:");

        lbHome.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbHome.setText("Desconhecida");

        btBreed.setBackground(new java.awt.Color(115, 160, 122));
        btBreed.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btBreed.setText("Escolher Raça");
        btBreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBreedActionPerformed(evt);
            }
        });

        cbBreed.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cbBreed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humana", "Anã", "Élfica", "Orc", "Goblina", "Gnomo", "Undead", "Bestial", "Construct", "Reptiliana", "Dracônica", "Sátiro" }));
        cbBreed.setToolTipText("");
        cbBreed.setEnabled(false);
        cbBreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBreedActionPerformed(evt);
            }
        });

        cbClass.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerreira", "Ladina", "Mago", "Druida", "Paladina", "Ranger", "Clériga", "Barda", "Fantasma", "Necromante", "Domador de Bestas", "Feiticeira", "Monge", "Ilusionista", "Mentalista" }));
        cbClass.setToolTipText("");
        cbClass.setEnabled(false);
        cbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClassActionPerformed(evt);
            }
        });

        btClass.setBackground(new java.awt.Color(230, 221, 138));
        btClass.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        btClass.setText("Escolher Classe");
        btClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClassActionPerformed(evt);
            }
        });

        lbClass.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbClass.setText("Classe:");

        lbClassValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbClassValue.setText("Desconhecida");

        lbMpValue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbMpValue.setText("??");

        lbMp.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbMp.setText("MP:");

        btSkills.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btSkills.setText("Ver");
        btSkills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSkillsActionPerformed(evt);
            }
        });

        cbSkills.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbSkills.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbSkills.setText("Habilidades:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Saiba+ sobre:");

        btInfoBreed.setBackground(new java.awt.Color(159, 136, 204));
        btInfoBreed.setText("Raça");
        btInfoBreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoBreedActionPerformed(evt);
            }
        });

        btInfoClass.setBackground(new java.awt.Color(159, 136, 204));
        btInfoClass.setText("Classe");
        btInfoClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoClassActionPerformed(evt);
            }
        });

        btInfoHomeland.setBackground(new java.awt.Color(159, 136, 204));
        btInfoHomeland.setText("Terra Natal");
        btInfoHomeland.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoHomelandActionPerformed(evt);
            }
        });

        btInfoAttr.setBackground(new java.awt.Color(159, 136, 204));
        btInfoAttr.setText("Atributos");
        btInfoAttr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoAttrActionPerformed(evt);
            }
        });

        btInfoPangeia.setBackground(new java.awt.Color(159, 136, 204));
        btInfoPangeia.setText("Pangeia");
        btInfoPangeia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoPangeiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbBreed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btClass, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbVit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbInt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbVitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbDexValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbForValue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbIntValue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCarValue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPerValue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbClass)
                            .addGap(18, 18, 18)
                            .addComponent(lbClassValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(lbHpValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(lbDfValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbAgeValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbMp)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbMpValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(8, 8, 8))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbBreed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(19, 19, 19))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbSkills)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btInfoPangeia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btInfoAttr))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btInfoBreed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btInfoClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btInfoHomeland)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btBreed)
                            .addComponent(cbBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btClass)
                            .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMod)
                            .addComponent(lbMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)))
                .addComponent(btGenerate)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbVit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbInt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHpValue)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbAgeValue)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbDfValue)
                                    .addComponent(lbMpValue)
                                    .addComponent(lbMp)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbForValue)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbDexValue)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbVitValue)
                            .addComponent(jLabel3)
                            .addComponent(lbBreed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIntValue)
                            .addComponent(lbClass)
                            .addComponent(lbClassValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPerValue)
                            .addComponent(jLabel6)
                            .addComponent(lbHome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCarValue)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btSkills)
                                .addComponent(cbSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbSkills)))))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInfoBreed)
                    .addComponent(btInfoClass)
                    .addComponent(btInfoHomeland)
                    .addComponent(btInfoAttr)
                    .addComponent(btInfoPangeia))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Updates the labels and chooses the attributes. 
     */
    private void btGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerateActionPerformed
        try{
            mod = Integer.parseInt(tfMod.getText()); 
            setBasicAttributes();
            setDependentAttributes();
            applyBreedMods(); 
            setRandomValues();
            resetSkills();
            setSkills();
        }catch(Exception e){
            mod = 1;
        }
    }//GEN-LAST:event_btGenerateActionPerformed

    /** Enables or Disables Breed JComboBox when called */
    private void btBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBreedActionPerformed
        //System.out.println(btBreed.getModel().isSelected());
        breedDisabled();
    }//GEN-LAST:event_btBreedActionPerformed

    private void cbBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBreedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBreedActionPerformed

    private void cbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClassActionPerformed

    /** Enables or Disables Class JComboBox when called */
    private void btClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClassActionPerformed
        //System.out.println(btClass.getModel().isSelected());
        classDisabled();
    }//GEN-LAST:event_btClassActionPerformed

    /** Opens skill info */
    private void btSkillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSkillsActionPerformed
        try{
            setSkInfo();
            sk.setVisible(true);
        }catch(Exception e){}

    }//GEN-LAST:event_btSkillsActionPerformed

    private void btInfoBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoBreedActionPerformed
        Breed info = new Breed();
        info.setVisible(true);
    }//GEN-LAST:event_btInfoBreedActionPerformed

    private void btInfoClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoClassActionPerformed
        ClassInfo info = new ClassInfo();
        info.setVisible(true);
    }//GEN-LAST:event_btInfoClassActionPerformed

    private void btInfoHomelandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoHomelandActionPerformed
        /*HomeLand info = new HomeLand();
        info.setVisible(true);*/
        soon();
    }//GEN-LAST:event_btInfoHomelandActionPerformed

    private void btInfoPangeiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoPangeiaActionPerformed
        /*Pangeia info = new Pangeia();
        info.setVisible(true);*/
        soon();
    }//GEN-LAST:event_btInfoPangeiaActionPerformed

    private void btInfoAttrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoAttrActionPerformed
        /*Atributos info = new Atributos();
        info.setVisible(true);*/
        soon();
    }//GEN-LAST:event_btInfoAttrActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CharacterGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharacterGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharacterGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharacterGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharacterGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btBreed;
    private javax.swing.JToggleButton btClass;
    private javax.swing.JButton btGenerate;
    private javax.swing.JButton btInfoAttr;
    private javax.swing.JButton btInfoBreed;
    private javax.swing.JButton btInfoClass;
    private javax.swing.JButton btInfoHomeland;
    private javax.swing.JButton btInfoPangeia;
    private javax.swing.JButton btSkills;
    private javax.swing.JComboBox<String> cbBreed;
    private javax.swing.JComboBox<String> cbClass;
    private javax.swing.JComboBox<String> cbSkills;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbAgeValue;
    private javax.swing.JLabel lbBreed;
    private javax.swing.JLabel lbCar;
    private javax.swing.JLabel lbCarValue;
    private javax.swing.JLabel lbClass;
    private javax.swing.JLabel lbClassValue;
    private javax.swing.JLabel lbDex;
    private javax.swing.JLabel lbDexValue;
    private javax.swing.JLabel lbDfValue;
    private javax.swing.JLabel lbFor;
    private javax.swing.JLabel lbForValue;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbHpValue;
    private javax.swing.JLabel lbInt;
    private javax.swing.JLabel lbIntValue;
    private javax.swing.JLabel lbMod;
    private javax.swing.JLabel lbMp;
    private javax.swing.JLabel lbMpValue;
    private javax.swing.JLabel lbPer;
    private javax.swing.JLabel lbPerValue;
    private javax.swing.JLabel lbSkills;
    private javax.swing.JLabel lbVit;
    private javax.swing.JLabel lbVitValue;
    private javax.swing.JTextField tfMod;
    // End of variables declaration//GEN-END:variables
}