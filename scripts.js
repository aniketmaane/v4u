// scripts.js
document.addEventListener('DOMContentLoaded', function() {
    const jobsContainer = document.querySelector('.jobs-container');

    // Example job data (this would typically come from your Django backend)
    const jobs = [
        { title: 'Software Engineer', company: 'Tech Corp', location: 'Remote' },
        { title: 'Data Analyst', company: 'Data Inc', location: 'New York' },
        { title: 'Product Manager', company: 'Innovate LLC', location: 'San Francisco' }
    ];

    jobs.forEach(job => {
        const jobCard = document.createElement('div');
        jobCard.classList.add('job-card');
        jobCard.innerHTML = `
            <h3>${job.title}</h3>
            <p><strong>Company:</strong> ${job.company}</p>
            <p><strong>Location:</strong> ${job.location}</p>
        `;
        jobsContainer.appendChild(jobCard);
    });

    // Contact form submission
    const contactForm = document.getElementById('contact-form');
    contactForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const message = document.getElementById('message').value;

        // Here you would typically send the form data to your Django backend
        console.log('Name:', name);
        console.log('Email:', email);
        console.log('Message:', message);

        alert('Thank you for contacting us!');
        contactForm.reset();
    });
});