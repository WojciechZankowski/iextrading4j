# Change Log
All notable changes to this project will be documented in this file.

## [3.4.5] - 2021-10-10

### Changed

- Added additional fields to basic Split response [[#122](https://github.com/WojciechZankowski/iextrading4j/issues/122)]

## [3.4.4] - 2021-05-15

### Changed

- Updated ```SymbolDescription``` model with additional fields

## [3.4.3] - 2021-04-03

### Added

- Added Corporate Actions - Advanced Distribution, Bonus, Splits

## [3.4.2] - 2021-01-08

### Changed

- Changes to Dividends model to synchronize with recent iCloud changes

## [3.4.0] - 2021-01-08

### Added

- Added `stable` endpoint [[#104](https://github.com/WojciechZankowski/iextrading4j/pull/104)] [@razine-bensari](https://github.com/razine-bensari)

### Changed

- Fixed date handling after iCloud update [[#106](https://github.com/WojciechZankowski/iextrading4j/pull/106)] [@JoseMariaBernad](https://github.com/JoseMariaBernad)
- Multiple changes to Chart, TimeSeries, BalanceSheet, CashFlow, Dividends, Financial, FundOwnership, IncomeStatement, InsiderTransaction, Ownership, ExchangeSymbol, SymbolDescription models to synchronize with recent iCloud changes
- Deprecated ```tranCode``` in InsiderTransaction as the field was renamed to transactionCode

## [3.3.4] - 2020-08-27

### Added

- Added support to no UTP SSE quotes [[#97](https://github.com/WojciechZankowski/iextrading4j/pull/97)] [@lucasbaizer2](https://github.com/lucasbaizer2)
- Added ```symbol``` to Dividens

## [3.3.3] - 2020-06-01

### Changed

- Added ```next``` to Dividends Range [[#94](https://github.com/WojciechZankowski/iextrading4j/pull/94)]
- Added ```figi``` and ```cik``` to ref data
- Added ```fiscalDate``` and ```currency``` to Balance Sheet
- Added ```fiscalDate``` and ```currency``` to Cash Flow
- Added ```fiscalDate``` and ```currency``` to Financials
- Added ```fiscalDate``` and ```currency``` to Income Statement
- Added ```currency``` to Price Targets
- Added ```highTime```, ```highSource```, ```lowTime```, ```lowSource```, ```iexOpen```, ```iexOpenTime```, ```iexClose```, ```iexCloseTime``` attributes to Stock Quote

## [3.3.2] - 2019-12-23

### Changed

- Fixed Earnings request with Last parameter [[#83](https://github.com/WojciechZankowski/iextrading4j/issues/83)]
- Fixed issue with different mapping providers [[#82](https://github.com/WojciechZankowski/iextrading4j/pull/82)]
- Added isDerived field to Currency Rate objects
- Added subattribute and dateField parameters to Time Series
- Added 1 second, 5 second, and 1 minute conflation rates for forex real time streaming
- Added annual earnings and estimates where previously only quarterly was available.

## [3.3.1] - 2019-11-03

### Added

- Time Series endpoint (TimeSeriesRequestBuilder.class)

## [3.3.0] - 2019-10-26

### Added

- Daily Sentiment request builder 

### Changed

- Added week52highDate and week52lowDate to AdvancedStats model
- Replaced CryptoBook and CryptoBookEntry with Book and BookEntry

## [3.2.8] - 2019-10-12

### Added

- Technical Indicator endpoint (TechnicalIndicatorRequestBuilder.class)
- Real-time SSE forex endpoint (CurrencyRatesSseRequestBuilder.class)
- Latest currency rates endpoint (LatestCurrencyRatesRequestBuilder.class)
- Historical currency rates endpoint (HistoricalRatesRequestBuilder.class)
- Currency conversion endpoint (CurrencyConversionRequestBuilder.class)

### Changed

- Fixed sentiment SSE event model [[#68](https://github.com/WojciechZankowski/iextrading4j/issues/68)]
- Added primarySicCode field to Company model
- Added tranCode and directIndirect fields to InsiderTransactions

## [3.2.7] - 2019-10-01

### Added

- Crypto Quote SSE endpoint
- Crypto Price endpoint
- Crypto Book endpoint
- Crypto Book SSE endpoint
- Crypto Event SSE endpoint

## [3.2.6] - 2019-09-08

### Added

- Batch endpoint support

### Changed

- Add circutBreaker and rename field to payAsYouGoEnabled in Metadata model
- Fixed parsing fund-ownership endpoint
- Add peHigh and peLow fields to AdvancedStats model

## [3.2.5] - 2019-08-22

### Changed

- Add isUSMarketOpen field to Quote model
- Add address field to Company model

## [3.2.4] - 2019-07-15

### Changed

- Fixed SSE Last/DEEP/Quotes response format

## [3.2.3] - 2019-07-12

### Added

- Added Options endpoint support

### Changed

- Fixed SSE TOPS response format

## [3.2.2] - 2019-07-09

### Changed

- Added 'lastTradeTime' field to Quote object
- Added new values to ChartRange

## [3.2.1] - 2019-07-07

### Added

- Support to Status endpoint
- Support to Search Symbol endpoint

## [3.2.0] - 2019-06-23

### Added

- Support to SSE
- Field 'refId' to UsExchange endpoint
- Field 'volume' to OHLC endpoint

### Deleted

- IEX Api endpoints: TOPS firehose from the request

## [3.1.1] - 2019-06-16

### Added

- Support to Pay as you go endpoint
- Support to Message Cutoff endpoint

### Deleted

- IEX Api endpoints: Batch, Chart, Company, KeyStats, Previous Quote, Open-Close, Quote

## [3.1.0] - 2019-05-30

### Added

- Support to U.S. Holidays and Trading Dates endpoint
- Support to Sectors endpoint
- Support to Tags endpoint
- Support to ISIN Mapping endpoint
- Support to Options Symbols endpoint
- Support to Data Points endpoint

### Deleted

- IEX Api endpoints: Collections, Crypto, Delayed Quote, Dividends, Financials, IPO Calendar, Largest Trades, Logo, News, Peers, Price, Relevant, Sector Performance, Splits

## [3.0.1] - 2019-05-12

### Added

- Support to Sentiment endpoint

### Changed

- Fixed issue with serialization roundtrip [[#38](https://github.com/WojciechZankowski/iextrading4j/issues/38)]
- Fixed issue with null in account usage endpoint [[#44](https://github.com/WojciechZankowski/iextrading4j/issues/44)]

## [3.0.0] - 2019-04-15

### Added

- Support to IEXCloud.io

## [2.3.0] - 2018-11-09

### Added

- Crypto endpoint support
- Ipos endpoint support
- Collection endpoint support
- Today earnings endpoint support
- Java SE 10, Java SE 11 support

## [2.2.5] - 2018-10-20

### Changed

- Add chart range parameter to Batch request [[#31](https://github.com/WojciechZankowski/iextrading4j/issues/31]

## [2.2.4] - 2018-09-30

### Changed

- Add autoreconnect after losing connection to websocket [[#30](https://github.com/WojciechZankowski/iextrading4j/issues/30]

## [2.2.3] - 2018-09-19
### Changed

- Add history hold field to IEX Corporate Actions

## [2.2.2] - 2018-07-04

### Changed

- Fix issue with Jersey dependency and Spring Boot [[#25](https://github.com/WojciechZankowski/iextrading4j/issues/25)]
- Updated external dependencies to the newest versions

## [2.2.1] - 2018-06-25

### Changed

- Fix HIST request without parameters [[#24](https://github.com/WojciechZankowski/iextrading4j/issues/24)]
- Removed output from acceptance test due to Travis log limit

## [2.2.0] - 2018-06-22

### Added

- Support for DEEP websocket requests
- Exception handling
- E2E websocket tests

### Changed

- Fixed toString method in Chart model // [Issue#22](https://github.com/WojciechZankowski/iextrading4j/issues/22)

## [2.1.8] - 2018-06-15

### Added

- Tags added to Company model

## [2.1.7] - 2018-06-13

### Added

- News image added to the News model

## [2.1.6] - 2018-05-27

### Added

- Stock Batch endpoint
- Stock Market Batch endpoint
- OHLC Market endpoint
- Previous Market endpoint

## [2.1.5] - 2018-05-24

### Added

- Largest Trades endpoint
- Extended change and extended changePercent to the Quote model

## [2.1.4] - 2018-05-22

### Added

- Extended price and extended price time to the Quote model

## [2.1.3] - 2018-05-02

### Changed

- Turned off throwing exception on unknown model properties

## [2.1.2] - 2018-04-30

### Changed

- Fixed issue with One-day Chart // [Issue#19](https://github.com/WojciechZankowski/iextrading4j/issues/19)
- Add new fields to Earning model

## [2.1.1] - 2018-03-13

### Changed

- Fixed issue with KeyStats // [Issue#15](https://github.com/WojciechZankowski/iextrading4j/issues/15) 

## [2.1.0] - 2018-03-02

### Added

- Request to /stock/time-series endpoint
- Request to /official-price endpoint
- Request to /stock/ohlc endpoint
- Request to /stock/short-interest endpoint 
- Request to /stock/threshold-securities endpoint
- Request to /ref-data/daily-list/symbol-directory endpoint
- Request to /ref-data/daily-list/corporate-actions endpoint
- Request to /ref-data/daily-list/dividends endpoint
- Request to /ref-data/daily-list/next-day-ex-date endpoint

### Changed

- Fixed WebSocket implementation, it is actually working right now
- Reorganized Chart model and requests. Library supports all types of chart requests 
- Increased code coverage

## [2.0.1] - 2017-12-28

### Added

- Fields High & Low to Quote object

## [2.0.0] - 2017-11-25

### Added

- Support to Stock API Endpoint
- Support to new Market Data API Endpoints

### Changed

- Library design, introduced new generic way to create requests. 

## [1.1.0] - 2017-04-21

### Added

- Support to RefData/Symbols API Endpoint

## [1.0.2] - 2017-03-21

### Added

- Introduced WebSockets implementation for Market Volume data
- Lots of unit tests

### Changed 

- Refactored WebSocket implementation. Separated objects for different Async Requests.
- Fixed problem with Double values display


[1.0.2]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_1_0_1...IT4J_RELEASE_1_0_2
[1.1.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_1_0_2...IT4J_RELEASE_1_1_0
[2.0.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_1_1_0...IT4J_RELEASE_2_0_0
[2.0.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_0_0...IT4J_RELEASE_2_0_1
[2.1.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_0_1...IT4J_RELEASE_2_1_0
[2.1.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_0...IT4J_RELEASE_2_1_1
[2.1.2]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_1...IT4J_RELEASE_2_1_2
[2.1.3]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_2...IT4J_RELEASE_2_1_3
[2.1.4]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_3...IT4J_RELEASE_2_1_4
[2.1.5]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_4...IT4J_RELEASE_2_1_5
[2.1.6]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_5...IT4J_RELEASE_2_1_6
[2.1.7]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_6...IT4J_RELEASE_2_1_7
[2.1.8]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_7...IT4J_RELEASE_2_1_8
[2.2.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_1_8...IT4J_RELEASE_2_2_0
[2.2.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_2_0...IT4J_RELEASE_2_2_1
[2.2.2]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_2_1...IT4J_RELEASE_2_2_2
[2.2.3]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_2_2...IT4J_RELEASE_2_2_3
[2.2.4]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_2_3...IT4J_RELEASE_2_2_4
[2.2.5]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_2_4...IT4J_RELEASE_2_2_5
[2.3.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_2_5...IT4J_RELEASE_2_3_0
[3.0.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_2_3_0...IT4J_RELEASE_3_0_0
[3.0.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_0_0...IT4J_RELEASE_3_0_1
[3.1.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_0_1...IT4J_RELEASE_3_1_0
[3.1.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_1_0...IT4J_RELEASE_3_1_1
[3.2.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_1_1...IT4J_RELEASE_3_2_0
[3.2.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_0...IT4J_RELEASE_3_2_1
[3.2.2]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_1...IT4J_RELEASE_3_2_2
[3.2.3]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_2...IT4J_RELEASE_3_2_3
[3.2.4]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_3...IT4J_RELEASE_3_2_4
[3.2.5]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_4...IT4J_RELEASE_3_2_5
[3.2.6]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_5...IT4J_RELEASE_3_2_6
[3.2.7]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_6...IT4J_RELEASE_3_2_7
[3.2.8]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_7...IT4J_RELEASE_3_2_8
[3.3.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_2_8...IT4J_RELEASE_3_3_0
[3.3.1]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_3_0...IT4J_RELEASE_3_3_1
[3.3.2]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_3_1...IT4J_RELEASE_3_3_2
[3.3.3]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_3_2...IT4J_RELEASE_3_3_3
[3.3.4]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_3_3...IT4J_RELEASE_3_3_4
[3.4.0]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_3_4...IT4J_RELEASE_3_4_0
[3.4.2]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_4_0...IT4J_RELEASE_3_4_2
[3.4.3]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_4_2...IT4J_RELEASE_3_4_3
[3.4.4]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_4_3...IT4J_RELEASE_3_4_4
[3.4.5]: https://github.com/WojciechZankowski/iextrading4j/compare/IT4J_RELEASE_3_4_4...IT4J_RELEASE_3_4_5
