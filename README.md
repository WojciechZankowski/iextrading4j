# IEXTrading4j: Open source IEX Trading REST API library

[![Build Status](https://travis-ci.org/WojciechZankowski/iextrading4j.svg?branch=master)](https://travis-ci.org/WojciechZankowski/iextrading4j)

## Table of Contents

* [IEX Trading](#iex-trading)
* [Endpoints](#endpoints)
 * [TOPS Endpoint](#tops-endpoint)
 * [Market Endpoint](#market-endpoint)
 * [Stats Endpoint](#stats-endpoint)
* [License](#license)

## IEX Trading

IEX A Fair, Simple, Transparent Exchange.

IEX is a stock exchange based in the United States. Started by Brad Katsuyama, it opened for trading on October 25, 2013. The company’s offices are located at 4 World Trade Center in New York City. The matching engine is located across the Hudson River in Weehawken, New Jersey, and the initial point of presence is located in a data center in Secaucus, New Jersey. IEX's main innovation is a 38-mile coil of optical fiber placed in front of its trading engine. This 350 microsecond delay adds a round-trip delay of 0.0007 seconds and is designed to negate the certain speed advantages utilized by some high-frequency traders.

IEX was created in response to questionable trading practices that had become widely used across traditional public Wall Street exchanges as well as dark pools and other alternative trading systems. The IEX exchange aims to attract investors by promising to "play fair" by operating in a transparent and straightforward manner, while also helping to level the playing field for traders. Strategies to achieve those goals include:

* Publishing the matching rules used in the exchanges's computerized order matching engine.
* Offering a limited number of simple and familiar order types.
* Charging fixed fees on most orders (or a flat percentage rate on small orders).
* Ensuring market pricing data arrives at external points of presence simultaneously.
* Slightly delaying market pricing data to all customers (no colocation).
* Refusing to pay for order flow.

Check out their beautiful site: [IEX Trading](https://iextrading.com/)


## Endpoints

### TOPS Endpoint

#### TOPS

* ``` /tops ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
TOPS[] allTOPS = iexTradingClient.getTopsEndpoint().requestTOPS();
Arrays.stream(allTOPS).forEach(System.out::println);
```

Result:

```
TOPS{symbol='PHMD', marketPercent=6.7E-4, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=100, lastSalePrice=1.79, lastSaleSize=100, lastSaleTime=1489414155874, lastUpdated=1489435057149}
TOPS{symbol='PKO', marketPercent=0.00248, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=100, lastSalePrice=24.2, lastSaleSize=100, lastSaleTime=1489430959012, lastUpdated=1489434520035}
TOPS{symbol='PLPC', marketPercent=0.01106, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=100, lastSalePrice=45.05, lastSaleSize=83, lastSaleTime=1489433595625, lastUpdated=1489431476892}
TOPS{symbol='PMD', marketPercent=0.00725, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=100, lastSalePrice=20.64, lastSaleSize=100, lastSaleTime=1489422055971, lastUpdated=1489432978304}
...
TOPS{symbol='PTLC', marketPercent=0.0, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=0, lastSalePrice=0.0, lastSaleSize=0, lastSaleTime=0, lastUpdated=1489411840544}
TOPS{symbol='PTMC', marketPercent=0.0, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=0, lastSalePrice=0.0, lastSaleSize=0, lastSaleTime=0, lastUpdated=1489411940552}
```

* ``` /tops?symbols=BMC,IBM ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
TOPS[] filteredTOPS = iexTradingClient.getTopsEndpoint().requestTOPS("BCM", "IBM");
Arrays.stream(filteredTOPS).forEach(System.out::println);
```

Result:

```
TOPS{symbol='BCM', marketPercent=0.0, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=0, lastSalePrice=0.0, lastSaleSize=0, lastSaleTime=0, lastUpdated=1489435200006}
TOPS{symbol='IBM', marketPercent=0.0179, bidSize=0, bidPrice=0.0, askSize=0, askPrice=0.0, volume=62344, lastSalePrice=176.45, lastSaleSize=100, lastSaleTime=1489435198942, lastUpdated=1489435200006}
```

#### Last

* ``` /tops/last ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
LastTrade[] allLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades();
Arrays.stream(allLastTrades).forEach(System.out::println);
```

Result:

```
LastTrade{symbol='MBLY', price=60.64, size=100, time=1489435198887}
LastTrade{symbol='FTR', price=2.545, size=100, time=1489435195124}
LastTrade{symbol='SIRI', price=5.44, size=1, time=1489435188064}
...
LastTrade{symbol='ZVZZT', price=10.015, size=95, time=1489432173271}
```

* ``` /tops/last?symbols=BMC,IBM ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
LastTrade[] filteredLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades("BCM", "IBM");
Arrays.stream(filteredLastTrades).forEach(System.out::println);
```

Result:

```
LastTrade{symbol='BCM', price=0.0, size=0, time=0}
LastTrade{symbol='IBM', price=176.45, size=100, time=1489435198942}
```

### Market Endpoint

* ``` /market ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
MarketVolume[] marketsVolume = iexTradingClient.getMarketEndpoint().requestMarketVolume();
Arrays.stream(marketsVolume).forEach(System.out::println);
```

Result:

```
MarketVolume{mic='XNYS', tapeId='N', venueName='NYSE', volume=738339624, tapeA=738339624, tapeB=0, tapeC=0, marketPercent=0.11935, lastUpdated=1489437900053}
...
MarketVolume{mic='XCHI', tapeId='M', venueName='CHX', volume=16475000, tapeA=5155704, tapeB=7013233, tapeC=4306063, marketPercent=0.00266, lastUpdated=1489438707493}
```

### Stats Endpoint

#### Intraday

* ``` /stats/intraday ```

Code example: 

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
IntradayStats intradayStats = iexTradingClient.getStatsEndpoint().requestIntradayStats();
System.out.println(intradayStats);
```

Result:

```
IntradayStats{volume=IntradayStat{value=1.34536591E8, lastUpdated=1489439703043}, symbolsTraded=IntradayStat{value=5648.0, lastUpdated=1489436001925}, routedVolume=IntradayStat{value=3.2495441E7, lastUpdated=1489439703043}, notional=IntradayStat{value=5.376618067E9, lastUpdated=1489439703043}, marketShare=IntradayStat{value=0.02175, lastUpdated=1489439701709}}
```

#### Recent

* ``` /stats/recent ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
RecentStats[] recentStats = iexTradingClient.getStatsEndpoint().requestRecentStat();
Arrays.stream(recentStats).forEach(System.out::println);
```

Result:

```
RecentStats{date=2017-03-10, volume=149135019, routedVolume=42123427, marketShare=0.021629999999999996, isHalfday=false, litVolume=39719692}
...
RecentStats{date=2017-03-01, volume=166582594, routedVolume=44586812, marketShare=0.020099999999999996, isHalfday=false, litVolume=42957311}
```

#### Records

* ``` /stats/records ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
RecordsStats recordsStat = iexTradingClient.getStatsEndpoint().requestRecordsStat();
System.out.println(recordsStat);
```

Result:

```
RecordsStats{volume=Record{recordValue=2.33000477E8, recordDate=2016-01-20, previousDayValue=1.49135019E8, avg30Value=1.444597065E8}, symbolsTraded=Record{recordValue=6046.0, recordDate=2016-11-10, previousDayValue=5591.0, avg30Value=5670.0}, routedVolume=Record{recordValue=7.4855222E7, recordDate=2016-11-10, previousDayValue=4.2123427E7, avg30Value=3.9506438E7}, notional=Record{recordValue=9.8878323278355E9, recordDate=2016-11-10, previousDayValue=6.24451614224E9, avg30Value=6.0611987261176E9}}
```

#### Historical summary

* ``` /stats/historical ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats();
Arrays.stream(historicalStats).forEach(System.out::println);
```

Result:

```
HistoricalStats{averageDailyVolume=1.431990607E8, averageDailyRoutedVolume=4.972976053E7, averageMarketShare=0.02084, averageOrderSize=725.0, averageFillSize=234.0, bin100Percent=0.69467, bin101Percent=0.69467, bin200Percent=0.69467, bin300Percent=0.69467, bin400Percent=0.69467, bin500Percent=0.69467, bin1000Percent=0.69467, bin5000Percent=0.69467, bin10000Percent=0.69467, bin10000Trades=4052.0, bin20000Trades=1448.0, bin50000Trades=216.0, uniqueSymbolsTraded=7722.0, blockPercent=0.07064, selfCrossPercent=0.03382, etfPercent=0.11663, largeCapPercent=0.42933, midCapPercent=0.28813, smallCapPercent=0.16591, venueARCXFirstWaveWeight=0.18884, venueBATSFirstWaveWeight=0.05175, venueBATYFirstWaveWeight=0.06428, venueEDGAFirstWaveWeight=0.00913, venueEDGXFirstWaveWeight=0.08463, venueOverallFirstWaveWeight=1.0, venueXASEFirstWaveWeight=0.00252, venueXBOSFirstWaveWeight=0.03266, venueXCHIFirstWaveWeight=0.00176, venueXCISFirstWaveWeight=0.0, venueXNGSFirstWaveWeight=0.19028, venueXNYSFirstWaveWeight=0.2481, venueXPHLFirstWaveWeight=0.01103, venueARCXFirstWaveRate=0.97697, venueBATSFirstWaveRate=0.98719, venueBATYFirstWaveRate=0.98058, venueEDGAFirstWaveRate=0.98961, venueEDGXFirstWaveRate=0.99106, venueOverallFirstWaveRate=0.97996, venueXASEFirstWaveRate=0.91259, venueXBOSFirstWaveRate=0.97117, venueXCHIFirstWaveRate=0.76701, venueXCISFirstWaveRate=0.0, venueXNGSFirstWaveRate=0.97581, venueXNYSFirstWaveRate=0.97746, venueXPHLFirstWaveRate=0.95374}
```

* ``` /stats/historical?date=201703 ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(YearMonth.of(2017, 3));
Arrays.stream(historicalStats).forEach(System.out::println);
```

Result:

```
HistoricalStats{averageDailyVolume=1.45192724E8, averageDailyRoutedVolume=5.473170862E7, averageMarketShare=0.0, averageOrderSize=680.0, averageFillSize=234.0, bin100Percent=0.70049, bin101Percent=0.70049, bin200Percent=0.70049, bin300Percent=0.70049, bin400Percent=0.70049, bin500Percent=0.70049, bin1000Percent=0.70049, bin5000Percent=0.70049, bin10000Percent=0.70049, bin10000Trades=1569.0, bin20000Trades=501.0, bin50000Trades=108.0, uniqueSymbolsTraded=7279.0, blockPercent=0.0642, selfCrossPercent=0.03122, etfPercent=0.13429, largeCapPercent=0.39449, midCapPercent=0.2766, smallCapPercent=0.19462, venueARCXFirstWaveWeight=0.1852, venueBATSFirstWaveWeight=0.05374, venueBATYFirstWaveWeight=0.06559, venueEDGAFirstWaveWeight=0.00935, venueEDGXFirstWaveWeight=0.08312, venueOverallFirstWaveWeight=1.0, venueXASEFirstWaveWeight=0.00198, venueXBOSFirstWaveWeight=0.03483, venueXCHIFirstWaveWeight=0.00164, venueXCISFirstWaveWeight=0.0, venueXNGSFirstWaveWeight=0.18084, venueXNYSFirstWaveWeight=0.24618, venueXPHLFirstWaveWeight=0.01061, venueARCXFirstWaveRate=0.97938, venueBATSFirstWaveRate=0.98756, venueBATYFirstWaveRate=0.984, venueEDGAFirstWaveRate=0.98836, venueEDGXFirstWaveRate=0.99148, venueOverallFirstWaveRate=0.98201, venueXASEFirstWaveRate=0.87702, venueXBOSFirstWaveRate=0.97138, venueXCHIFirstWaveRate=0.66283, venueXCISFirstWaveRate=0.0, venueXNGSFirstWaveRate=0.98077, venueXNYSFirstWaveRate=0.9787, venueXPHLFirstWaveRate=0.95596}
```

#### Historical daily

* ``` /stats/historical/daily ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats();
Arrays.stream(historicalDailyStats).forEach(System.out::println);
```

Result:

```
HistoricalDailyStats{date=2017-03-10, volume=149135019, routedVolume=42123427, marketShare=0.021629999999999996, isHalfday=false, litVolume=39719692}
```

* ``` /stats/historical/daily?date=201703 ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(YearMonth.of(2017,3));
Arrays.stream(historicalDailyStats).forEach(System.out::println);
```

Result:

```
HistoricalDailyStats{date=2017-03-10, volume=149135019, routedVolume=42123427, marketShare=0.021629999999999996, isHalfday=false, litVolume=39719692}
...
HistoricalDailyStats{date=2017-03-01, volume=166582594, routedVolume=44586812, marketShare=0.020099999999999996, isHalfday=false, litVolume=42957311}
```

* ``` /stats/historical/daily?date=20170306 ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(LocalDate.of(2017, 3, 6));
Arrays.stream(historicalDailyStats).forEach(System.out::println);
```

Result:

```
HistoricalDailyStats{date=2017-03-06, volume=123478859, routedVolume=34541901, marketShare=0.01977, isHalfday=false, litVolume=30610152}
```

* ``` /stats/historical/daily?last=13 ```

Code example:

```java
IEXTradingClient iexTradingClient = IEXTradingClient.create();
HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(13);
Arrays.stream(historicalDailyStats).forEach(System.out::println);
```

Result:

```
HistoricalDailyStats{date=2017-03-10, volume=149135019, routedVolume=42123427, marketShare=0.021629999999999996, isHalfday=false, litVolume=39719692}
...
HistoricalDailyStats{date=2017-02-22, volume=137030945, routedVolume=38173711, marketShare=0.02086, isHalfday=false, litVolume=34027926}
```

## License

Code and documentation released under the Apache License, Version 2.0
