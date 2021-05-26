package bonsen.nl.puzzled.service.address;

import bonsen.nl.puzzled.exceptions.RecordNotFoundException;
import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public String createAddress(Address address) {
        addressRepository.save(address);
        return address.getId();
    }

    @Override
    public boolean updateAddress(Address newAddress) {
        String id = newAddress.getId();
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.setStreetName(newAddress.getStreetName());
            address.setHouseNumber(newAddress.getHouseNumber());
            address.setPostalCode(newAddress.getPostalCode());
            address.setCity(newAddress.getCity());
            address.setCountry(newAddress.getCountry());
            addressRepository.save(address);
            return true;
        }
        throw new RecordNotFoundException();
    }

    @Override
    public boolean deleteAddress(String id) {
        addressRepository.deleteById(id);
        return !addressRepository.existsById(id);
    }
}
