package org.helixj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {

    public static final String coinName = "Helix";
    public static final String coinTicker = "HLIX";
    public static final String coinURIScheme = "helix";
    public static final String cryptsyMarketId = "5447";
    public static final String cryptsyMarketCurrency = "HLIX";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/phr/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "ttp://explorer.helix-crypto.com/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.dash.org/";

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(1 * 60);  // 60 second difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 60);  // 60 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            //return INTERVAL;
        return 150;
    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 50; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 1000000000;                 //main.h:  MAX_MONEY

    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 30000; //main.h CTransaction::GetMinFee        0.01 coins
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // Helix 0.12
    //
    public static final int PROTOCOL_VERSION = 80012;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 80011;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 37415;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 37417;     //protocol.h GetDefaultPort(testnet=true)

    /** Zerocoin starting block height */
    public static final long TESTNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 201576;
    public static final long MAINNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 90202;

    //
    //  Production
    //
    public static final int AddressHeader = 40;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 13;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0x3be759f0;  //0x3b, 0xe7, 0x59, 0xf0;
    public static final long TestnetPacketMagic = 0x4f6c7e7a; // 0x4f, 0x6c, 0x7e, 0x7a,

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = 0x207fffff;         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1531496589L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = 192840;                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "79a3c45d6e2760efb4d6de76d34b1f4833ba919bc114e1da0f671b1700a78f08";  //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "210fa744202cef1c9248d9f82efadaa1387341e5c4b85b7a87ae56866514ef27";
    static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "crazyseeder.helix-crypto.com",
            "173.212.198.12",
            "seed1.helix-crypto.com",
            "seed2.helix-crypto.com",
            "seed3.helix-crypto.com",
            "seed4.helix-crypto.com",
            "seed5.helix-crypto.com"
    };

    public static int minBroadcastConnections = 3;   //0 for default; we need more peers.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 127;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x4f6c7e7a;      //
    public static final String testnetGenesisHash =  "79a3c45d6e2760efb4d6de76d34b1f4833ba919bc114e1da0f671b1700a78f08";
    static public long testnetGenesisBlockDifficultyTarget = (0x207fffff);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1531496589L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (192838L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int nHeight)
    {
        Coin nSubsidy;
        if (nHeight == 0) {
            nSubsidy = Coin.valueOf(5000000, 0);
        } else if (nHeight > 0 && nHeight <= 200) {
            nSubsidy = Coin.valueOf(0, 0);
        } else if (nHeight > 200 && nHeight <= 90200) {
            nSubsidy = Coin.valueOf(111, 0);
        } else if (nHeight > 90200 && nHeight <= 525600) {
            nSubsidy = Coin.valueOf(15, 0);
        } else if (nHeight > 525600 && nHeight <= 1576800) {
            nSubsidy = Coin.valueOf(13, 5);
        } else if (nHeight > 1576800 && nHeight <= 2628000) {
            nSubsidy = Coin.valueOf(10, 8);
        } else if (nHeight > 2628000 && nHeight <= 58545900) {
            nSubsidy = Coin.valueOf(8, 1);
        } else if (nHeight > 58545900 && nHeight <= 58545902) {
            nSubsidy = Coin.valueOf(4, 2);
        } else {
            nSubsidy = Coin.valueOf(0, 0);
        }
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x207fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnetseed"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "043747a78571fb1aaa306f9b51c03ab0bd39b7186f7c9c321adb7c50f7f2955c7f8254c530e134bd886ea8f8cfabe4bed01b25b7cd3245709cd2f7fd5e263c881a";
    public static final String TESTNET_SATOSHI_KEY = "0462af22b469d8c12de76a033b81378b0c4c7694c19863b073f51b34476d5b39ba88769ab83e9e48389985fd838d41704449b9ece1fd36720b9116338b8fb30794";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "mainnet";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "testnet";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(    0, Sha256Hash.wrap("79a3c45d6e2760efb4d6de76d34b1f4833ba919bc114e1da0f671b1700a78f08"));
        checkpoints.put(    54, Sha256Hash.wrap("000000035eb76b5ce0362a4ef3c542bebe50ac6cd110e9b81d1ed45c49442e26"));
        checkpoints.put(    55, Sha256Hash.wrap("00000003ad0648bc2a2d27634d9962650ffabe9f78a3a4d8772e148c3f1b8ead"));
        checkpoints.put(    56, Sha256Hash.wrap("00000003f6036f9f58b327f70f874d7bdb1db0b3db44d2812abd872f35a7c5fb"));
        checkpoints.put( 1000, Sha256Hash.wrap("0000000000035895b91ae55236883f81cf3fcb62f0d6cadaf49a0eca7ef1e07b"));
        checkpoints.put(10000, Sha256Hash.wrap("000000000001cefb823e793c7c27ad4b74feb5990e7f68127a10ef59b9ab19c7"));
        checkpoints.put(50000, Sha256Hash.wrap("000000000009cdaeb5cf0ef84355153aa38e942d750e6000d73d04a4ce4e6c9b"));
        checkpoints.put(90000, Sha256Hash.wrap("000000000000e4573d249e86972aebf57ce377d7342d8bbba351c3f331588c4f"));
        checkpoints.put(150000, Sha256Hash.wrap("108aac50762723fe319931b12a063ffa08465e707db7f624f3b9d1fa446822b4"));
        checkpoints.put(200000, Sha256Hash.wrap("25d5407abbca5b217bdebe143fbd06427980e46e14e516150d3c58b77e03ea91"));
        checkpoints.put(250000, Sha256Hash.wrap("5733cac18dfbad3a95b9343272bab90670b0df8b7ff7c0353249b9601002f64e"));
        checkpoints.put(262639, Sha256Hash.wrap("ead6534cc6ff592028f860a9bc17aa4aa0759de6261a534e4c87d2e91890aece"));
        checkpoints.put(306705, Sha256Hash.wrap("273d590dd52ff6a352db7e676143da6a17dda6926513e2d3dd25c62bd3e730af"));
        checkpoints.put(350000, Sha256Hash.wrap("95dba3af31b2eee5df3e5d4bc87c7860a523a0d1efaea9b5b590ad5f8bb9acea"));
        checkpoints.put(400000, Sha256Hash.wrap("f7f411e13a8559b82defd209611b659794ad59a2f10ef0e89630e990dedb5083"));
        checkpoints.put(450000, Sha256Hash.wrap("1a22f0fd98f1dd900108c8b5ede8de256dba79596bd781aa0dfb00bf4e2331fd"));
        checkpoints.put(500000, Sha256Hash.wrap("3f7e8645f8b40288ef94812ad64fb2b1b6f8d7c5006db521c2f6c4104552acd1"));
        checkpoints.put(550000, Sha256Hash.wrap("c86d2d309bbc461cb393958d2d6845fbc82438d73b04a9f5db7bf31a2cddbe1c"));
        checkpoints.put(600000, Sha256Hash.wrap("d18555608c63695084e8563e69440ea5f748f93837ff430e8254813bbadb1b66"));
        checkpoints.put(609119, Sha256Hash.wrap("9004db2b6444af84d4cf61b59b250ba65fefdf2f3e9ed48b9c1114b2f2bfaa2a"));
        checkpoints.put(609120, Sha256Hash.wrap("19964e3827800eeb75cfb96de0a8d1818a7e7ba82fbe65128b6d2d2a30cdf6e9"));
        checkpoints.put(609121, Sha256Hash.wrap("89fc025c860d4028ef26ffd037c53b6275d46e5806a8bfeb33066ff8c3dcac02"));
        checkpoints.put(650000, Sha256Hash.wrap("0647bd41acf0c9defe91699ca3901ca7cf86be7f528c3fd26b14f9ce2531fd63"));
        checkpoints.put(700000, Sha256Hash.wrap("159dc1e73e968a793282f686a3408afe41c72c358019ccb9e22711a66fda77b9"));
        checkpoints.put(750000, Sha256Hash.wrap("80a663fb9a25eadb265fa6965f2ff7e6e6217dba9e7a7ff16cc389fe3348423f"));
        checkpoints.put(800000, Sha256Hash.wrap("a32bc7b377cc193eb438f5577165e793cf79aa517abe5582d801c6917a553e5a"));
        checkpoints.put(838474, Sha256Hash.wrap("9c199cb19eb94c619c007ec267466c49ad65dc28d62f52fba9a6e5001f817ffb"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
