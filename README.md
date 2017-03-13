# IEXTrading4j: Open source IEX Trading REST API library

[![Build Status](https://travis-ci.org/WojciechZankowski/iextrading4j.svg?branch=master)](https://travis-ci.org/WojciechZankowski/iextrading4j)

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
