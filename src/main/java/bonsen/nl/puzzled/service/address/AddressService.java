package bonsen.nl.puzzled.service.address;

import bonsen.nl.puzzled.model.address.Address;

public interface AddressService {
    public abstract String createAddress(Address address);
    public abstract void updateAddress(Address address);
    public abstract void deleteAddress(String id);
}
