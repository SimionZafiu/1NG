<?php
class Main_model extends CI_Model {    
    function getData($data="no Data")
    {
        $query = $this->db->get('transaction_type', 10);
        return $query->result();
    }

    function getCustomers()
    {
        $query = $this->db->get('customers', 10);
        return $query->result();
    }

}
