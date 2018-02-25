package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.ListingCenter;

import static pl.zankowski.iextrading4j.client.mapper.ListingCenterDeserializer.LISTING_CENTER_MAPPER;

class ListingCenterSerializer extends AbstractEnumSerializer<ListingCenter> {

    ListingCenterSerializer() {
        super(LISTING_CENTER_MAPPER.inverse(), ListingCenter.UNKNOWN);
    }

}
