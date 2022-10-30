<?php

header("Access-Control-Allow-Origin: *");
require "image_upload.php";

$method = $_SERVER['REQUEST_METHOD'];
if ($method == "GET") {
    echo "<h1 style='text-align:center'>CAN NOT ACCESS<h1>";
    exit(1);
}




$image_uploader = new ImageUploader($_POST['email'], $_POST['password']);
$type = $_POST['type'];

switch ($type) {

    case "set_profile_photo":
        $image_uploader->setProfilePhoto();
        break;

    case "set_main_service_image":
        $image_uploader->setMainServiceImage();
        break;

    case "add_slide":
        $image_uploader->addImageSlide();
        break;


    default:
        die("FAILED");
}


// $test->authUser("jojo_2002@gmail.com", "12345");

// $imgid = uniqid("", false);
// $post_image = $_FILES['image']['name'];
// $end = strtok($post_image, ".");
// $end = strtok('.'); //to get the extension of the file
// $post_image_temp = $_FILES['image']['tmp_name'];

// $imgName = "$imgid.$end";
// move_uploaded_file($post_image_temp, "data/$imgid.$end");
