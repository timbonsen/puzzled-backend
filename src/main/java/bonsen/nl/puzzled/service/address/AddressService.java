package bonsen.nl.puzzled.service.address;

import bonsen.nl.puzzled.model.address.Address;

public interface AddressService {
    String createAddress(Address address);
    boolean updateAddress(Address address);
    boolean deleteAddress(String id);
}
