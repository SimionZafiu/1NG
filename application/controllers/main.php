<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Main extends CI_Controller {
	
	public function index()
	{
		
		$this->load->view("main_view");
	}

	public function test()
	{
		$this->load->model("main_model");
		$getData = $this->main_model->getData("data from Model");

		echo "<br> ".$getData;
	}
}

/* End of file main.php */
/* Location: ./application/controllers/main.php */