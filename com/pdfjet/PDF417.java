/**
 *  PDF417.java
 *
Copyright 2020 Innovatics Inc.
*/

package com.pdfjet;


class PDF417 {

public static final int[][] TABLE = {
{0,31111136,51111125,21111155,},
{1,41111144,61111133,31111163,},
{2,51111152,41111216,11111246,},
{3,31111235,51111224,21111254,},
{4,41111243,61111232,31111262,},
{5,51111251,41111315,11111345,},
{6,21111326,51111323,21111353,},
{7,31111334,61111331,31111361,},
{8,21111425,41111414,11111444,},
{9,11111516,51111422,21111452,},
{10,21111524,41111513,11111543,},
{11,11111615,51111521,61112114,},
{12,21112136,41111612,11112155,},
{13,31112144,41112125,21112163,},
{14,41112152,51112133,61112213,},
{15,21112235,61112141,11112254,},
{16,31112243,31112216,21112262,},
{17,41112251,41112224,61112312,},
{18,11112326,51112232,11112353,},
{19,21112334,31112315,21112361,},
{20,11112425,41112323,61112411,},
{21,11113136,51112331,11112452,},
{22,21113144,31112414,51113114,},
{23,31113152,41112422,61113122,},
{24,11113235,31112513,11113163,},
{25,21113243,41112521,51113213,},
{26,31113251,31112612,61113221,},
{27,11113334,31113125,11113262,},
{28,21113342,41113133,51113312,},
{29,11114144,51113141,11113361,},
{30,21114152,21113216,51113411,},
{31,11114243,31113224,41114114,},
{32,21114251,41113232,51114122,},
{33,11115152,21113315,41114213,},
{34,51116111,31113323,51114221,},
{35,31121135,41113331,41114312,},
{36,41121143,21113414,41114411,},
{37,51121151,31113422,31115114,},
{38,21121226,21113513,41115122,},
{39,31121234,31113521,31115213,},
{40,41121242,21113612,41115221,},
{41,21121325,21114125,31115312,},
{42,31121333,31114133,31115411,},
{43,11121416,41114141,21116114,},
{44,21121424,11114216,31116122,},
{45,31121432,21114224,21116213,},
{46,11121515,31114232,31116221,},
{47,21121523,11114315,21116312,},
{48,11121614,21114323,11121146,},
{49,21122135,31114331,21121154,},
{50,31122143,11114414,31121162,},
{51,41122151,21114422,11121245,},
{52,11122226,11114513,21121253,},
{53,21122234,21114521,31121261,},
{54,31122242,11115125,11121344,},
{55,11122325,21115133,21121352,},
{56,21122333,31115141,11121443,},
{57,31122341,11115224,21121451,},
{58,11122424,21115232,11121542,},
{59,21122432,11115323,61122113,},
{60,11123135,21115331,11122154,},
{61,21123143,11115422,21122162,},
{62,31123151,11116133,61122212,},
{63,11123234,21116141,11122253,},
{64,21123242,11116232,21122261,},
{65,11123333,11116331,61122311,},
{66,21123341,41121116,11122352,},
{67,11124143,51121124,11122451,},
{68,21124151,61121132,51123113,},
{69,11124242,41121215,61123121,},
{70,11124341,51121223,11123162,},
{71,21131126,61121231,51123212,},
{72,31131134,41121314,11123261,},
{73,41131142,51121322,51123311,},
{74,21131225,41121413,41124113,},
{75,31131233,51121421,51124121,},
{76,41131241,41121512,41124212,},
{77,11131316,41121611,41124311,},
{78,21131324,31122116,31125113,},
{79,31131332,41122124,41125121,},
{80,11131415,51122132,31125212,},
{81,21131423,31122215,31125311,},
{82,11131514,41122223,21126113,},
{83,11131613,51122231,31126121,},
{84,11132126,31122314,21126212,},
{85,21132134,41122322,21126311,},
{86,31132142,31122413,11131145,},
{87,11132225,41122421,21131153,},
{88,21132233,31122512,31131161,},
{89,31132241,31122611,11131244,},
{90,11132324,21123116,21131252,},
{91,21132332,31123124,11131343,},
{92,11132423,41123132,21131351,},
{93,11132522,21123215,11131442,},
{94,11133134,31123223,11131541,},
{95,21133142,41123231,61132112,},
{96,11133233,21123314,11132153,},
{97,21133241,31123322,21132161,},
{98,11133332,21123413,61132211,},
{99,11134142,31123421,11132252,},
{100,21141125,21123512,11132351,},
{101,31141133,21123611,51133112,},
{102,41141141,11124116,11133161,},
{103,11141216,21124124,51133211,},
{104,21141224,31124132,41134112,},
{105,31141232,11124215,41134211,},
{106,11141315,21124223,31135112,},
{107,21141323,31124231,31135211,},
{108,31141331,11124314,21136112,},
{109,11141414,21124322,21136211,},
{110,21141422,11124413,11141144,},
{111,11141513,21124421,21141152,},
{112,21141521,11124512,11141243,},
{113,11142125,11125124,21141251,},
{114,21142133,21125132,11141342,},
{115,31142141,11125223,11141441,},
{116,11142224,21125231,61142111,},
{117,21142232,11125322,11142152,},
{118,11142323,11125421,11142251,},
{119,21142331,11126132,51143111,},
{120,11142422,11126231,41144111,},
{121,11142521,41131115,31145111,},
{122,21143141,51131123,11151143,},
{123,11143331,61131131,21151151,},
{124,11151116,41131214,11151242,},
{125,21151124,51131222,11151341,},
{126,31151132,41131313,11152151,},
{127,11151215,51131321,11161142,},
{128,21151223,41131412,11161241,},
{129,31151231,41131511,12111146,},
{130,11151314,31132115,22111154,},
{131,21151322,41132123,32111162,},
{132,11151413,51132131,12111245,},
{133,21151421,31132214,22111253,},
{134,11151512,41132222,32111261,},
{135,11152124,31132313,12111344,},
{136,11152223,41132321,22111352,},
{137,11152322,31132412,12111443,},
{138,11161115,31132511,22111451,},
{139,31161131,21133115,12111542,},
{140,21161222,31133123,62112113,},
{141,21161321,41133131,12112154,},
{142,11161511,21133214,22112162,},
{143,32111135,31133222,62112212,},
{144,42111143,21133313,12112253,},
{145,52111151,31133321,22112261,},
{146,22111226,21133412,62112311,},
{147,32111234,21133511,12112352,},
{148,42111242,11134115,12112451,},
{149,22111325,21134123,52113113,},
{150,32111333,31134131,62113121,},
{151,42111341,11134214,12113162,},
{152,12111416,21134222,52113212,},
{153,22111424,11134313,12113261,},
{154,12111515,21134321,52113311,},
{155,22112135,11134412,42114113,},
{156,32112143,11134511,52114121,},
{157,42112151,11135123,42114212,},
{158,12112226,21135131,42114311,},
{159,22112234,11135222,32115113,},
{160,32112242,11135321,42115121,},
{161,12112325,11136131,32115212,},
{162,22112333,41141114,32115311,},
{163,12112424,51141122,22116113,},
{164,12112523,41141213,32116121,},
{165,12113135,51141221,22116212,},
{166,22113143,41141312,22116311,},
{167,32113151,41141411,21211145,},
{168,12113234,31142114,31211153,},
{169,22113242,41142122,41211161,},
{170,12113333,31142213,11211236,},
{171,12113432,41142221,21211244,},
{172,12114143,31142312,31211252,},
{173,22114151,31142411,11211335,},
{174,12114242,21143114,21211343,},
{175,12115151,31143122,31211351,},
{176,31211126,21143213,11211434,},
{177,41211134,31143221,21211442,},
{178,51211142,21143312,11211533,},
{179,31211225,21143411,21211541,},
{180,41211233,11144114,11211632,},
{181,51211241,21144122,12121145,},
{182,21211316,11144213,22121153,},
{183,31211324,21144221,32121161,},
{184,41211332,11144312,11212145,},
{185,21211415,11144411,12121244,},
{186,31211423,11145122,22121252,},
{187,41211431,11145221,11212244,},
{188,21211514,41151113,21212252,},
{189,31211522,51151121,22121351,},
{190,22121126,41151212,11212343,},
{191,32121134,41151311,12121442,},
{192,42121142,31152113,11212442,},
{193,21212126,41152121,12121541,},
{194,22121225,31152212,11212541,},
{195,32121233,31152311,62122112,},
{196,42121241,21153113,12122153,},
{197,21212225,31153121,22122161,},
{198,31212233,21153212,61213112,},
{199,41212241,21153311,62122211,},
{200,11212316,11154113,11213153,},
{201,12121415,21154121,12122252,},
{202,22121423,11154212,61213211,},
{203,32121431,11154311,11213252,},
{204,11212415,41161112,12122351,},
{205,21212423,41161211,11213351,},
{206,11212514,31162112,52123112,},
{207,12122126,31162211,12123161,},
{208,22122134,21163112,51214112,},
{209,32122142,21163211,52123211,},
{210,11213126,42111116,11214161,},
{211,12122225,52111124,51214211,},
{212,22122233,62111132,42124112,},
{213,32122241,42111215,41215112,},
{214,11213225,52111223,42124211,},
{215,21213233,62111231,41215211,},
{216,31213241,42111314,32125112,},
{217,11213324,52111322,31216112,},
{218,12122423,42111413,32125211,},
{219,11213423,52111421,31216211,},
{220,12123134,42111512,22126112,},
{221,22123142,42111611,22126211,},
{222,11214134,32112116,11221136,},
{223,12123233,42112124,21221144,},
{224,22123241,52112132,31221152,},
{225,11214233,32112215,11221235,},
{226,21214241,42112223,21221243,},
{227,11214332,52112231,31221251,},
{228,12124142,32112314,11221334,},
{229,11215142,42112322,21221342,},
{230,12124241,32112413,11221433,},
{231,11215241,42112421,21221441,},
{232,31221125,32112512,11221532,},
{233,41221133,32112611,11221631,},
{234,51221141,22113116,12131144,},
{235,21221216,32113124,22131152,},
{236,31221224,42113132,11222144,},
{237,41221232,22113215,12131243,},
{238,21221315,32113223,22131251,},
{239,31221323,42113231,11222243,},
{240,41221331,22113314,21222251,},
{241,21221414,32113322,11222342,},
{242,31221422,22113413,12131441,},
{243,21221513,32113421,11222441,},
{244,21221612,22113512,62132111,},
{245,22131125,22113611,12132152,},
{246,32131133,12114116,61223111,},
{247,42131141,22114124,11223152,},
{248,21222125,32114132,12132251,},
{249,22131224,12114215,11223251,},
{250,32131232,22114223,52133111,},
{251,11222216,32114231,51224111,},
{252,12131315,12114314,42134111,},
{253,31222232,22114322,41225111,},
{254,32131331,12114413,32135111,},
{255,11222315,22114421,31226111,},
{256,12131414,12114512,22136111,},
{257,22131422,12115124,11231135,},
{258,11222414,22115132,21231143,},
{259,21222422,12115223,31231151,},
{260,22131521,22115231,11231234,},
{261,12131612,12115322,21231242,},
{262,12132125,12115421,11231333,},
{263,22132133,12116132,21231341,},
{264,32132141,12116231,11231432,},
{265,11223125,51211115,11231531,},
{266,12132224,61211123,12141143,},
{267,22132232,11211164,22141151,},
{268,11223224,51211214,11232143,},
{269,21223232,61211222,12141242,},
{270,22132331,11211263,11232242,},
{271,11223323,51211313,12141341,},
{272,12132422,61211321,11232341,},
{273,12132521,11211362,12142151,},
{274,12133133,51211412,11233151,},
{275,22133141,51211511,11241134,},
{276,11224133,42121115,21241142,},
{277,12133232,52121123,11241233,},
{278,11224232,62121131,21241241,},
{279,12133331,41212115,11241332,},
{280,11224331,42121214,11241431,},
{281,11225141,61212131,12151142,},
{282,21231116,41212214,11242142,},
{283,31231124,51212222,12151241,},
{284,41231132,52121321,11242241,},
{285,21231215,41212313,11251133,},
{286,31231223,42121412,21251141,},
{287,41231231,41212412,11251232,},
{288,21231314,42121511,11251331,},
{289,31231322,41212511,12161141,},
{290,21231413,32122115,11252141,},
{291,31231421,42122123,11261132,},
{292,21231512,52122131,11261231,},
{293,21231611,31213115,13111145,},
{294,12141116,32122214,23111153,},
{295,22141124,42122222,33111161,},
{296,32141132,31213214,13111244,},
{297,11232116,41213222,23111252,},
{298,12141215,42122321,13111343,},
{299,22141223,31213313,23111351,},
{300,32141231,32122412,13111442,},
{301,11232215,31213412,13111541,},
{302,21232223,32122511,63112112,},
{303,31232231,31213511,13112153,},
{304,11232314,22123115,23112161,},
{305,12141413,32123123,63112211,},
{306,22141421,42123131,13112252,},
{307,11232413,21214115,13112351,},
{308,21232421,22123214,53113112,},
{309,11232512,32123222,13113161,},
{310,12142124,21214214,53113211,},
{311,22142132,31214222,43114112,},
{312,11233124,32123321,43114211,},
{313,12142223,21214313,33115112,},
{314,22142231,22123412,33115211,},
{315,11233223,21214412,23116112,},
{316,21233231,22123511,23116211,},
{317,11233322,21214511,12211136,},
{318,12142421,12124115,22211144,},
{319,11233421,22124123,32211152,},
{320,11234132,32124131,12211235,},
{321,11234231,11215115,22211243,},
{322,21241115,12124214,32211251,},
{323,31241123,22124222,12211334,},
{324,41241131,11215214,22211342,},
{325,21241214,21215222,12211433,},
{326,31241222,22124321,22211441,},
{327,21241313,11215313,12211532,},
{328,31241321,12124412,12211631,},
{329,21241412,11215412,13121144,},
{330,21241511,12124511,23121152,},
{331,12151115,12125123,12212144,},
{332,22151123,22125131,13121243,},
{333,32151131,11216123,23121251,},
{334,11242115,12125222,12212243,},
{335,12151214,11216222,22212251,},
{336,22151222,12125321,12212342,},
{337,11242214,11216321,13121441,},
{338,21242222,12126131,12212441,},
{339,22151321,51221114,63122111,},
{340,11242313,61221122,13122152,},
{341,12151412,11221163,62213111,},
{342,11242412,51221213,12213152,},
{343,12151511,61221221,13122251,},
{344,12152123,11221262,12213251,},
{345,11243123,51221312,53123111,},
{346,11243222,11221361,52214111,},
{347,11243321,51221411,43124111,},
{348,31251122,42131114,42215111,},
{349,31251221,52131122,33125111,},
{350,21251411,41222114,32216111,},
{351,22161122,42131213,23126111,},
{352,12161213,52131221,21311135,},
{353,11252213,41222213,31311143,},
{354,11252312,51222221,41311151,},
{355,11252411,41222312,11311226,},
{356,23111126,42131411,21311234,},
{357,33111134,41222411,31311242,},
{358,43111142,32132114,11311325,},
{359,23111225,42132122,21311333,},
{360,33111233,31223114,31311341,},
{361,13111316,32132213,11311424,},
{362,23111324,42132221,21311432,},
{363,33111332,31223213,11311523,},
{364,13111415,41223221,21311531,},
{365,23111423,31223312,11311622,},
{366,13111514,32132411,12221135,},
{367,13111613,31223411,22221143,},
{368,13112126,22133114,32221151,},
{369,23112134,32133122,11312135,},
{370,33112142,21224114,12221234,},
{371,13112225,22133213,22221242,},
{372,23112233,32133221,11312234,},
{373,33112241,21224213,21312242,},
{374,13112324,31224221,22221341,},
{375,23112332,21224312,11312333,},
{376,13112423,22133411,12221432,},
{377,13112522,21224411,11312432,},
{378,13113134,12134114,12221531,},
{379,23113142,22134122,11312531,},
{380,13113233,11225114,13131143,},
{381,23113241,12134213,23131151,},
{382,13113332,22134221,12222143,},
{383,13114142,11225213,13131242,},
{384,13114241,21225221,11313143,},
{385,32211125,11225312,12222242,},
{386,42211133,12134411,13131341,},
{387,52211141,11225411,11313242,},
{388,22211216,12135122,12222341,},
{389,32211224,11226122,11313341,},
{390,42211232,12135221,13132151,},
{391,22211315,11226221,12223151,},
{392,32211323,51231113,11314151,},
{393,42211331,61231121,11321126,},
{394,22211414,11231162,21321134,},
{395,32211422,51231212,31321142,},
{396,22211513,11231261,11321225,},
{397,32211521,51231311,21321233,},
{398,23121125,42141113,31321241,},
{399,33121133,52141121,11321324,},
{400,43121141,41232113,21321332,},
{401,22212125,51232121,11321423,},
{402,23121224,41232212,21321431,},
{403,33121232,42141311,11321522,},
{404,12212216,41232311,11321621,},
{405,13121315,32142113,12231134,},
{406,32212232,42142121,22231142,},
{407,33121331,31233113,11322134,},
{408,12212315,32142212,12231233,},
{409,22212323,31233212,22231241,},
{410,23121422,32142311,11322233,},
{411,12212414,31233311,21322241,},
{412,13121513,22143113,11322332,},
{413,12212513,32143121,12231431,},
{414,13122125,21234113,11322431,},
{415,23122133,31234121,13141142,},
{416,33122141,21234212,12232142,},
{417,12213125,22143311,13141241,},
{418,13122224,21234311,11323142,},
{419,32213141,12144113,12232241,},
{420,12213224,22144121,11323241,},
{421,22213232,11235113,11331125,},
{422,23122331,12144212,21331133,},
{423,12213323,11235212,31331141,},
{424,13122422,12144311,11331224,},
{425,12213422,11235311,21331232,},
{426,13123133,12145121,11331323,},
{427,23123141,11236121,21331331,},
{428,12214133,51241112,11331422,},
{429,13123232,11241161,11331521,},
{430,12214232,51241211,12241133,},
{431,13123331,42151112,22241141,},
{432,13124141,41242112,11332133,},
{433,12215141,42151211,12241232,},
{434,31311116,41242211,11332232,},
{435,41311124,32152112,12241331,},
{436,51311132,31243112,11332331,},
{437,31311215,32152211,13151141,},
{438,41311223,31243211,12242141,},
{439,51311231,22153112,11333141,},
{440,31311314,21244112,11341124,},
{441,41311322,22153211,21341132,},
{442,31311413,21244211,11341223,},
{443,41311421,12154112,21341231,},
{444,31311512,11245112,11341322,},
{445,22221116,12154211,11341421,},
{446,32221124,11245211,12251132,},
{447,42221132,51251111,11342132,},
{448,21312116,42161111,12251231,},
{449,22221215,41252111,11342231,},
{450,41312132,32162111,11351123,},
{451,42221231,31253111,21351131,},
{452,21312215,22163111,11351222,},
{453,31312223,21254111,11351321,},
{454,41312231,43111115,12261131,},
{455,21312314,53111123,11352131,},
{456,22221413,63111131,11361122,},
{457,32221421,43111214,11361221,},
{458,21312413,53111222,14111144,},
{459,31312421,43111313,24111152,},
{460,22221611,53111321,14111243,},
{461,13131116,43111412,24111251,},
{462,23131124,43111511,14111342,},
{463,33131132,33112115,14111441,},
{464,12222116,43112123,14112152,},
{465,13131215,53112131,14112251,},
{466,23131223,33112214,54113111,},
{467,33131231,43112222,44114111,},
{468,11313116,33112313,34115111,},
{469,12222215,43112321,24116111,},
{470,22222223,33112412,13211135,},
{471,32222231,33112511,23211143,},
{472,11313215,23113115,33211151,},
{473,21313223,33113123,13211234,},
{474,31313231,43113131,23211242,},
{475,23131421,23113214,13211333,},
{476,11313314,33113222,23211341,},
{477,12222413,23113313,13211432,},
{478,22222421,33113321,13211531,},
{479,11313413,23113412,14121143,},
{480,13131611,23113511,24121151,},
{481,13132124,13114115,13212143,},
{482,23132132,23114123,14121242,},
{483,12223124,33114131,13212242,},
{484,13132223,13114214,14121341,},
{485,23132231,23114222,13212341,},
{486,11314124,13114313,14122151,},
{487,12223223,23114321,13213151,},
{488,22223231,13114412,12311126,},
{489,11314223,13114511,22311134,},
{490,21314231,13115123,32311142,},
{491,13132421,23115131,12311225,},
{492,12223421,13115222,22311233,},
{493,13133132,13115321,32311241,},
{494,12224132,13116131,12311324,},
{495,13133231,52211114,22311332,},
{496,11315132,62211122,12311423,},
{497,12224231,12211163,22311431,},
{498,31321115,52211213,12311522,},
{499,41321123,62211221,12311621,},
{500,51321131,12211262,13221134,},
{501,31321214,52211312,23221142,},
{502,41321222,12211361,12312134,},
{503,31321313,52211411,13221233,},
{504,41321321,43121114,23221241,},
{505,31321412,53121122,12312233,},
{506,31321511,42212114,13221332,},
{507,22231115,43121213,12312332,},
{508,32231123,53121221,13221431,},
{509,42231131,42212213,12312431,},
{510,21322115,52212221,14131142,},
{511,22231214,42212312,13222142,},
{512,41322131,43121411,14131241,},
{513,21322214,42212411,12313142,},
{514,31322222,33122114,13222241,},
{515,32231321,43122122,12313241,},
{516,21322313,32213114,21411125,},
{517,22231412,33122213,31411133,},
{518,21322412,43122221,41411141,},
{519,22231511,32213213,11411216,},
{520,21322511,42213221,21411224,},
{521,13141115,32213312,31411232,},
{522,23141123,33122411,11411315,},
{523,33141131,32213411,21411323,},
{524,12232115,23123114,31411331,},
{525,13141214,33123122,11411414,},
{526,23141222,22214114,21411422,},
{527,11323115,23123213,11411513,},
{528,12232214,33123221,21411521,},
{529,22232222,22214213,11411612,},
{530,23141321,32214221,12321125,},
{531,11323214,22214312,22321133,},
{532,21323222,23123411,32321141,},
{533,13141412,22214411,11412125,},
{534,11323313,13124114,12321224,},
{535,12232412,23124122,22321232,},
{536,13141511,12215114,11412224,},
{537,12232511,13124213,21412232,},
{538,13142123,23124221,22321331,},
{539,23142131,12215213,11412323,},
{540,12233123,22215221,12321422,},
{541,13142222,12215312,11412422,},
{542,11324123,13124411,12321521,},
{543,12233222,12215411,11412521,},
{544,13142321,13125122,13231133,},
{545,11324222,12216122,23231141,},
{546,12233321,13125221,12322133,},
{547,13143131,12216221,13231232,},
{548,11325131,61311113,11413133,},
{549,31331114,11311154,12322232,},
{550,41331122,21311162,13231331,},
{551,31331213,61311212,11413232,},
{552,41331221,11311253,12322331,},
{553,31331312,21311261,11413331,},
{554,31331411,61311311,14141141,},
{555,22241114,11311352,13232141,},
{556,32241122,11311451,12323141,},
{557,21332114,52221113,11414141,},
{558,22241213,62221121,11421116,},
{559,32241221,12221162,21421124,},
{560,21332213,51312113,31421132,},
{561,31332221,61312121,11421215,},
{562,21332312,11312162,21421223,},
{563,22241411,12221261,31421231,},
{564,21332411,51312212,11421314,},
{565,13151114,52221311,21421322,},
{566,23151122,11312261,11421413,},
{567,12242114,51312311,21421421,},
{568,13151213,43131113,11421512,},
{569,23151221,53131121,11421611,},
{570,11333114,42222113,12331124,},
{571,12242213,43131212,22331132,},
{572,22242221,41313113,11422124,},
{573,11333213,51313121,12331223,},
{574,21333221,43131311,22331231,},
{575,13151411,41313212,11422223,},
{576,11333312,42222311,21422231,},
{577,12242411,41313311,11422322,},
{578,11333411,33132113,12331421,},
{579,12243122,43132121,11422421,},
{580,11334122,32223113,13241132,},
{581,11334221,33132212,12332132,},
{582,41341121,31314113,13241231,},
{583,31341311,32223212,11423132,},
{584,32251121,33132311,12332231,},
{585,22251212,31314212,11423231,},
{586,22251311,32223311,11431115,},
{587,13161113,31314311,21431123,},
{588,12252113,23133113,31431131,},
{589,11343113,33133121,11431214,},
{590,13161311,22224113,21431222,},
{591,12252311,23133212,11431313,},
{592,24111125,21315113,21431321,},
{593,14111216,22224212,11431412,},
{594,24111224,23133311,11431511,},
{595,14111315,21315212,12341123,},
{596,24111323,22224311,22341131,},
{597,34111331,21315311,11432123,},
{598,14111414,13134113,12341222,},
{599,24111422,23134121,11432222,},
{600,14111513,12225113,12341321,},
{601,24111521,13134212,11432321,},
{602,14112125,11316113,13251131,},
{603,24112133,12225212,12342131,},
{604,34112141,13134311,11433131,},
{605,14112224,11316212,11441114,},
{606,24112232,12225311,21441122,},
{607,14112323,11316311,11441213,},
{608,24112331,13135121,21441221,},
{609,14112422,12226121,11441312,},
{610,14112521,61321112,11441411,},
{611,14113133,11321153,12351122,},
{612,24113141,21321161,11442122,},
{613,14113232,61321211,12351221,},
{614,14113331,11321252,11442221,},
{615,14114141,11321351,11451113,},
{616,23211116,52231112,21451121,},
{617,33211124,12231161,11451212,},
{618,43211132,51322112,11451311,},
{619,23211215,52231211,12361121,},
{620,33211223,11322161,11452121,},
{621,23211314,51322211,15111143,},
{622,33211322,43141112,25111151,},
{623,23211413,42232112,15111242,},
{624,33211421,43141211,15111341,},
{625,23211512,41323112,15112151,},
{626,14121116,42232211,14211134,},
{627,24121124,41323211,24211142,},
{628,34121132,33142112,14211233,},
{629,13212116,32233112,24211241,},
{630,14121215,33142211,14211332,},
{631,33212132,31324112,14211431,},
{632,34121231,32233211,15121142,},
{633,13212215,31324211,14212142,},
{634,23212223,23143112,15121241,},
{635,33212231,22234112,14212241,},
{636,13212314,23143211,13311125,},
{637,14121413,21325112,23311133,},
{638,24121421,22234211,33311141,},
{639,13212413,21325211,13311224,},
{640,23212421,13144112,23311232,},
{641,14121611,12235112,13311323,},
{642,14122124,13144211,23311331,},
{643,24122132,11326112,13311422,},
{644,13213124,12235211,13311521,},
{645,14122223,11326211,14221133,},
{646,24122231,61331111,24221141,},
{647,13213223,11331152,13312133,},
{648,23213231,11331251,14221232,},
{649,13213322,52241111,13312232,},
{650,14122421,51332111,14221331,},
{651,14123132,43151111,13312331,},
{652,13214132,42242111,15131141,},
{653,14123231,41333111,14222141,},
{654,13214231,33152111,13313141,},
{655,32311115,32243111,12411116,},
{656,42311123,31334111,22411124,},
{657,52311131,23153111,32411132,},
{658,32311214,22244111,12411215,},
{659,42311222,21335111,22411223,},
{660,32311313,13154111,32411231,},
{661,42311321,12245111,12411314,},
{662,32311412,11336111,22411322,},
{663,32311511,11341151,12411413,},
{664,23221115,44111114,22411421,},
{665,33221123,54111122,12411512,},
{666,22312115,44111213,12411611,},
{667,23221214,54111221,13321124,},
{668,33221222,44111312,23321132,},
{669,22312214,44111411,12412124,},
{670,32312222,34112114,13321223,},
{671,33221321,44112122,23321231,},
{672,22312313,34112213,12412223,},
{673,23221412,44112221,22412231,},
{674,22312412,34112312,12412322,},
{675,23221511,34112411,13321421,},
{676,22312511,24113114,12412421,},
{677,14131115,34113122,14231132,},
{678,24131123,24113213,13322132,},
{679,13222115,34113221,14231231,},
{680,14131214,24113312,12413132,},
{681,33222131,24113411,13322231,},
{682,12313115,14114114,12413231,},
{683,13222214,24114122,21511115,},
{684,23222222,14114213,31511123,},
{685,24131321,24114221,41511131,},
{686,12313214,14114312,21511214,},
{687,22313222,14114411,31511222,},
{688,14131412,14115122,21511313,},
{689,12313313,14115221,31511321,},
{690,13222412,53211113,21511412,},
{691,14131511,63211121,21511511,},
{692,13222511,13211162,12421115,},
{693,14132123,53211212,22421123,},
{694,24132131,13211261,32421131,},
{695,13223123,53211311,11512115,},
{696,14132222,44121113,12421214,},
{697,12314123,54121121,22421222,},
{698,13223222,43212113,11512214,},
{699,14132321,44121212,21512222,},
{700,12314222,43212212,22421321,},
{701,13223321,44121311,11512313,},
{702,14133131,43212311,12421412,},
{703,13224131,34122113,11512412,},
{704,12315131,44122121,12421511,},
{705,41411114,33213113,11512511,},
{706,51411122,34122212,13331123,},
{707,41411213,33213212,23331131,},
{708,51411221,34122311,12422123,},
{709,41411312,33213311,13331222,},
{710,41411411,24123113,11513123,},
{711,32321114,34123121,12422222,},
{712,42321122,23214113,13331321,},
{713,31412114,24123212,11513222,},
{714,41412122,23214212,12422321,},
{715,42321221,24123311,11513321,},
{716,31412213,23214311,14241131,},
{717,41412221,14124113,13332131,},
{718,31412312,24124121,12423131,},
{719,32321411,13215113,11514131,},
{720,31412411,14124212,21521114,},
{721,23231114,13215212,31521122,},
{722,33231122,14124311,21521213,},
{723,22322114,13215311,31521221,},
{724,23231213,14125121,21521312,},
{725,33231221,13216121,21521411,},
{726,21413114,62311112,12431114,},
{727,22322213,12311153,22431122,},
{728,32322221,22311161,11522114,},
{729,21413213,62311211,12431213,},
{730,31413221,12311252,22431221,},
{731,23231411,12311351,11522213,},
{732,21413312,53221112,21522221,},
{733,22322411,13221161,11522312,},
{734,21413411,52312112,12431411,},
{735,14141114,53221211,11522411,},
{736,24141122,12312161,13341122,},
{737,13232114,52312211,12432122,},
{738,14141213,44131112,13341221,},
{739,24141221,43222112,11523122,},
{740,12323114,44131211,12432221,},
{741,13232213,42313112,11523221,},
{742,23232221,43222211,21531113,},
{743,11414114,42313211,31531121,},
{744,12323213,34132112,21531212,},
{745,22323221,33223112,21531311,},
{746,14141411,34132211,12441113,},
{747,11414213,32314112,22441121,},
{748,21414221,33223211,11532113,},
{749,13232411,32314211,12441212,},
{750,11414312,24133112,11532212,},
{751,14142122,23224112,12441311,},
{752,13233122,24133211,11532311,},
{753,14142221,22315112,13351121,},
{754,12324122,23224211,12442121,},
{755,13233221,22315211,11533121,},
{756,11415122,14134112,21541112,},
{757,12324221,13225112,21541211,},
{758,11415221,14134211,12451112,},
{759,41421113,12316112,11542112,},
{760,51421121,13225211,12451211,},
{761,41421212,12316211,11542211,},
{762,41421311,11411144,16111142,},
{763,32331113,21411152,16111241,},
{764,42331121,11411243,15211133,},
{765,31422113,21411251,25211141,},
{766,41422121,11411342,15211232,},
{767,31422212,11411441,15211331,},
{768,32331311,62321111,16121141,},
{769,31422311,12321152,15212141,},
{770,23241113,61412111,14311124,},
{771,33241121,11412152,24311132,},
{772,22332113,12321251,14311223,},
{773,23241212,11412251,24311231,},
{774,21423113,53231111,14311322,},
{775,22332212,52322111,14311421,},
{776,23241311,51413111,15221132,},
{777,21423212,44141111,14312132,},
{778,22332311,43232111,15221231,},
{779,21423311,42323111,14312231,},
{780,14151113,41414111,13411115,},
{781,24151121,34142111,23411123,},
{782,13242113,33233111,33411131,},
{783,23242121,32324111,13411214,},
{784,12333113,31415111,23411222,},
{785,13242212,24143111,13411313,},
{786,14151311,23234111,23411321,},
{787,11424113,22325111,13411412,},
{788,12333212,21416111,13411511,},
{789,13242311,14144111,14321123,},
{790,11424212,13235111,24321131,},
{791,12333311,12326111,13412123,},
{792,11424311,11421143,23412131,},
{793,13243121,21421151,13412222,},
{794,11425121,11421242,14321321,},
{795,41431211,11421341,13412321,},
{796,31432112,12331151,15231131,},
{797,31432211,11422151,14322131,},
{798,22342112,11431142,13413131,},
{799,21433112,11431241,22511114,},
{800,21433211,11441141,32511122,},
{801,13252112,45111113,22511213,},
{802,12343112,45111212,32511221,},
{803,11434112,45111311,22511312,},
{804,11434211,35112113,22511411,},
{805,15111116,45112121,13421114,},
{806,15111215,35112212,23421122,},
{807,25111223,35112311,12512114,},
{808,15111314,25113113,22512122,},
{809,15111413,35113121,23421221,},
{810,15111512,25113212,12512213,},
{811,15112124,25113311,13421312,},
{812,15112223,15114113,12512312,},
{813,15112322,25114121,13421411,},
{814,15112421,15114212,12512411,},
{815,15113132,15114311,14331122,},
{816,15113231,15115121,13422122,},
{817,24211115,54211112,14331221,},
{818,24211214,14211161,12513122,},
{819,34211222,54211211,13422221,},
{820,24211313,45121112,12513221,},
{821,34211321,44212112,31611113,},
{822,24211412,45121211,41611121,},
{823,24211511,44212211,31611212,},
{824,15121115,35122112,31611311,},
{825,25121123,34213112,22521113,},
{826,14212115,35122211,32521121,},
{827,24212123,34213211,21612113,},
{828,25121222,25123112,22521212,},
{829,14212214,24214112,21612212,},
{830,24212222,25123211,22521311,},
{831,14212313,24214211,21612311,},
{832,24212321,15124112,13431113,},
{833,14212412,14215112,23431121,},
{834,15121511,15124211,12522113,},
{835,14212511,14215211,13431212,},
{836,15122123,63311111,11613113,},
{837,25122131,13311152,12522212,},
{838,14213123,13311251,13431311,},
{839,24213131,54221111,11613212,},
{840,14213222,53312111,12522311,},
{841,15122321,45131111,11613311,},
{842,14213321,44222111,14341121,},
{843,15123131,43313111,13432121,},
{844,14214131,35132111,12523121,},
{845,33311114,34223111,11614121,},
{846,33311213,33314111,31621112,},
{847,33311312,25133111,31621211,},
{848,33311411,24224111,22531112,},
{849,24221114,23315111,21622112,},
{850,23312114,15134111,22531211,},
{851,33312122,14225111,21622211,},
{852,34221221,13316111,13441112,},
{853,23312213,12411143,12532112,},
{854,33312221,22411151,13441211,},
{855,23312312,12411242,11623112,},
{856,24221411,12411341,12532211,},
{857,23312411,13321151,11623211,},
{858,15131114,12412151,31631111,},
{859,14222114,11511134,22541111,},
{860,15131213,21511142,21632111,},
{861,25131221,11511233,13451111,},
{862,13313114,21511241,12542111,},
{863,14222213,11511332,11633111,},
{864,15131312,11511431,16211132,},
{865,13313213,12421142,16211231,},
{866,14222312,11512142,15311123,},
{867,15131411,12421241,25311131,},
{868,13313312,11512241,15311222,},
{869,14222411,11521133,15311321,},
{870,15132122,21521141,16221131,},
{871,14223122,11521232,15312131,},
{872,15132221,11521331,14411114,},
{873,13314122,12431141,24411122,},
{874,14223221,11522141,14411213,},
{875,13314221,11531132,24411221,},
{876,42411113,11531231,14411312,},
{877,42411212,11541131,14411411,},
{878,42411311,36112112,15321122,},
{879,33321113,36112211,14412122,},
{880,32412113,26113112,15321221,},
{881,42412121,26113211,14412221,},
{882,32412212,16114112,23511113,},
{883,33321311,16114211,33511121,},
{884,32412311,45212111,23511212,},
{885,24231113,36122111,23511311,},
{886,34231121,35213111,14421113,},
{887,23322113,26123111,24421121,},
{888,33322121,25214111,13512113,},
{889,22413113,16124111,23512121,},
{890,23322212,15215111,13512212,},
{891,24231311,14311151,14421311,},
{892,22413212,13411142,13512311,},
{893,23322311,13411241,15331121,},
{894,22413311,12511133,14422121,},
{895,15141113,22511141,13513121,},
{896,25141121,12511232,32611112,},
{897,14232113,12511331,32611211,},
{898,24232121,13421141,23521112,},
{899,13323113,12512141,22612112,},
{900,14232212,11611124,23521211,},
{901,15141311,21611132,22612211,},
{902,12414113,11611223,14431112,},
{903,13323212,21611231,13522112,},
{904,14232311,11611322,14431211,},
{905,12414212,11611421,12613112,},
{906,13323311,12521132,13522211,},
{907,15142121,11612132,12613211,},
{908,14233121,12521231,32621111,},
{909,13324121,11612231,23531111,},
{910,12415121,11621123,22622111,},
{911,51511112,21621131,14441111,},
{912,51511211,11621222,13532111,},
{913,42421112,11621321,12623111,},
{914,41512112,12531131,16311122,},
{915,42421211,11622131,16311221,},
{916,41512211,11631122,15411113,},
{917,33331112,11631221,25411121,},
{918,32422112,14411141,15411212,},
{919,33331211,13511132,15411311,},
{920,31513112,13511231,16321121,},
{921,32422211,12611123,15412121,},
{922,31513211,22611131,24511112,},
{923,24241112,12611222,24511211,},
{924,23332112,12611321,15421112,},
{925,24241211,13521131,14512112,},
{926,22423112,12612131,15421211,},
{927,23332211,12621122,14512211,},
{928,21514112,12621221,33611111,},
};

}   // End of PDF417.java