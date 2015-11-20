<?php
class Main_model extends CI_Model {    
    function getData($data="no Data")
    {
        /*$query = $this->db->get('entries', 10);
        return $query->result();
        */
        return $data;
    }

}
