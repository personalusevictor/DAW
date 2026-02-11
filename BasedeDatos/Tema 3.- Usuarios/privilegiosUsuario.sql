create user victor1 IDENTIFIED BY 'victor';
create user victor2 identified by 'victor';

grant all on tienda_virtual.* to victor2;

show grants for victor2;

grant select, alter on tienda_virtual.producto to victor1;

show grants for victor1;