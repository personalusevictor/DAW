create user victor3 identified by 'victor';

grant all on tienda_virtual.* to victor3;

revoke insert on tienda_virtual.* from victor3;